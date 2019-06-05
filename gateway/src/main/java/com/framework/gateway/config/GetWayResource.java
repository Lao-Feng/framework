package com.framework.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: FengJie
 * @Date: 2019/4/13 18:50
 * @Description: swagger  配置
 */
@Component
@Primary
public class GetWayResource implements SwaggerResourcesProvider {
    public static final String API_URI = "/v2/api-docs";

    @Autowired
    private final RouteLocator routeLocator;
    @Value("${server.filter.name}")
    private String filterUrl;

    public GetWayResource(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<String> routes = new ArrayList<>();
        //获取eureka中路由信息
        routeLocator.getRoutes().subscribe(route -> routes.add(route.getId().replace("CompositeDiscoveryClient_", "")));
        resources.add(this.swaggerResource("default", "/swagger-resources/v2/api-docs", "2.0"));
        routes.forEach((route) -> {
            String lowerRoute = route.toLowerCase();
            if (!filterUrl.contains(lowerRoute)) {
                resources.add(this.swaggerResource(lowerRoute, "/" + lowerRoute + API_URI, "2.0"));
            }
        });
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}

