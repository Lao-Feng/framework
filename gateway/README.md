# 基础依赖框架
#### 一、作用
* 作为服务注册中心
* 作为分布式配置中心

#### 二、技术栈

#### 三、使用
* 第一步，下载并解压 [windows](https://github.com/alibaba/nacos/releases/download/1.0.0/nacos-server-1.0.0.zip) [linux](https://github.com/alibaba/nacos/releases/download/1.0.0/nacos-server-1.0.0.tar.gz)
* 第二步, 到bin目录，启动 `startup.cmd`
* 第三步，访问浏览器， http://127.0.0.1:8848/nacos，账户：nacos 密码：nacos
* 第四步，添加对应的配置文件，以下逻辑出几个模块的配置文件 <br>
**gateway** <br>
Data ID: gateway-dev.yaml <br>
Group  ： DEFAULT_GROUP  <br>
配置内容：
```yaml
server:
  port: 8080

spring:
  cloud:
    nacos:
      discovery:
        server-addr: 192.168.30.21:8848
    gateway:
      routes:
      - id: order
        uri: lb://order
        predicates:
        - Path=/order/**
        filters:
        - SwaggerHeaderFilter
        - StripPrefix=1

```

**order** <br>
Data ID: order-dev.yaml <br>
Group  ： DEFAULT_GROUP  <br>
配置内容：
```yaml
server:
  port: 8001

spring:
  application:
    name: order

  #### 数据库配置
  datasource:
    druid:
      url: jdbc:mysql://192.168.30.21:3306/tourism?autoReconnect=true&useSSL=false
      username: root
      password: 123456
      driver-class-name: com.mysql.cj.jdbc.Driver
      initial-size: 5
      max-active: 30
      min-idle: 5
      max-wait: 60000
      time-between-eviction-runs-millis: 60000
      min-evictable-idle-time-millis: 300000
      connection-properties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500

  cloud:
    nacos:
      discovery:
        server-addr: 192.168.30.21:8848

#### mybatis 配置
mybatis:
  mapper-locations: classpath:mapper/*.xml
  configuration:
    map-underscore-to-camel-case: true

#### feign 配置
feign:
  httpclient:
    enabled: true

```

#### 四、修改原生的数据库
 todo