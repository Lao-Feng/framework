#       framework （架构师-脚手架工程）  持续完善中。。。[GitHub](https://github.com/Lao-Feng/framework)
[TOC]

由于最近思考了领域驱动,打算把项目改造成领域驱动模型,不单单是一个普通的脚手架,所以最近今天都不会提交新的代码

### 一、概述
&nbsp; &nbsp; &nbsp;最近在这段时间主要从事公司的基础架构建设，包括技术选型、环境搭建、项目基础模块搭建...<br>
&nbsp; &nbsp; &nbsp;在此过程中真正意义干了一部分架构师或者运维这边的工作。虽然此过程枯燥无法,而且踩了无数坑，比如如何定义parent模块、如何定义basic模块、gateway仅支持webflux等等。由于之前都是一直用别人写好的，完全不能理会其中的很多设计意义，所以通过此工程的搭建，真正意义在经验上有了很大的提升。
&nbsp; &nbsp; &nbsp;记录此过程，主要是要提醒自己，万事一定要自己去亲手试，鞭策自己不断学习，同时也分析给各位，让大家尽量少走很多弯路。此脚手架还正在不断完善中，我后面再忙一定会把这个项目好好打造，由于自己的能力有限，希望各位能提供宝贵的意见，邮箱: 2109921940@qq.com，感激不尽。

### 二、技术体系
**SpringBoot**：<br>
**SpringCloud**: Gateway 、Feign <br>
**Spring**：Security <br>
**Nacos**：注册中心、配置中心 <br>
**Redis** <br>
**ElasticSearch** <br>
**MySQL** <br>
**Mybatis** <br>
**Swagger** <br>
**RabbitMQ** <br>

辅助 <br>
**Docker** <br>
**Nexus** <br>
**Gitlib** <br>


以上是主要的技术架构，其中包含了很多优化，比如HttpClient的替换等各种优化。各种技术都会有具体的实现，本项目结合电商做一个demo，大家可以基于这个做扩展。

### 三、模块说明
**[nacos](./nacos/README.md)** <br>
**[parent](./parent/README.md)** <br>
**[basic](./basic/README.md)** <br>
**[gateway](./gateway/README.md)** <br>
**[order](./order/README.md)** <br>
**[generate-util](./generate-util/README.md)** <br>

### 四、使用方法


### 四、采坑记录
* 1.gateway采坑
gateway和zuul都是一样，这里两个的功能我就不过多描述。比较大的区别是gateway底层用的是webflux，zuul需要依赖 spring-boot-starter-web，web底层是servlet，所以所在使用gateway的时候需要排除spring-boot-starter-web。如果是单独的一个模块，无须引入spring-boot-starter-web即可，但是我是依赖的自己封装的basic，所以需要排除spring-boot-starter-web。

* 2.swagger采坑
在springCloud单模块的使用swagger很简单，但是作为多模块项目，这个时候怎么对前端开发人员集中展示swagger接口呢？其实只需要在gateway依赖swagger即可。本案例已经实现

* 3.docker采坑
本案例所有的中间件、已经部署都在docker中的，在docker中也踩了不少的雷，后面我环境部署完后，整理一个docker的文档，把所有的中间件下载、运行命令都集中起来。

* 4.nacos 配置中心
其实关于nacos的用法网上有很多教程，我就不再说明。nacos作为配置中心，默认的配置文件类型是properties，但是如果我们手动添加的配置文件是yaml类型的时候，在client端需要注明类型，否则client端不能匹配配置文件
```yaml
spring:
  application:
    name: order
  cloud:
    nacos:
      config:
        file-extension: yaml
        server-addr: localhost:8044
```

### 五、说明
该项目正在逐渐完善。。。


[GitHub](https://github.com/Lao-Feng)&nbsp; &nbsp;[个人博客](http://118.126.112.183:4000/) &nbsp; &nbsp;[简书](https://www.jianshu.com/u/63299b8dc868) &nbsp; &nbsp;[CSDN](https://blog.csdn.net/lao__feng) &nbsp; &nbsp;[开源中国](https://my.oschina.net/u/3865326)















