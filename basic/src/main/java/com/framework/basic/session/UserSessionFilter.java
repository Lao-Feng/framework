package com.framework.basic.session;


import cn.hutool.core.util.StrUtil;
import com.framework.basic.util.SessionUtils;
import lombok.val;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: FengJie
 * @Date: 2019/4/10 17:42
 * @Description: session过滤器
 */
@Component
@WebFilter
@ConditionalOnClass(Filter.class)
public class UserSessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        SessionUtils.set(buildUserSession((HttpServletRequest) request));
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    private UserSession buildUserSession(HttpServletRequest request) {
        // TODO: 2019/4/11 这里需要继续完善用户信息

        return UserSession.builder()
                //.userId(Long.valueOf(getHeader(request, HeaderField.USER_ID)))
                .build();
    }

    private String getHeader(HttpServletRequest request, String name) {
        val value = request.getHeader(name);
        return StringUtils.hasLength(value) ? StrUtil.utf8Str(value) : StrUtil.EMPTY;
    }
}
