#        framework （架构师-脚手架工程） 持续完善中。。。
[TOC]

##### 一、概述
&nbsp; &nbsp; &nbsp;最近在这段时间主要从事公司的基础架构建设，包括技术选型、环境搭建、项目基础模块搭建...
&nbsp; &nbsp; &nbsp;在此过程中真正意义干了一部分架构师或者运维这边的工作。虽然此过程枯燥无法,而且踩了无数坑，比如如何定义parent模块、如何定义basic模块、gateway仅支持webflux等等。由于之前都是一直用别人写好的，完全不能理会其中的很多设计意义，所以通过此工程的搭建，真正意义在经验上有了很大的提升。
&nbsp; &nbsp; &nbsp;记录此过程，主要是要提醒自己，万事一定要自己去亲手试，鞭策自己不断学习，同时也分析给各位，让大家尽量少走很多弯路。此脚手架还正在不断完善中，我后面再忙一定会把这个项目好好打造，由于自己的能力有限，希望各位能提供宝贵的意见，邮箱: 2109921940@qq.com，感激不尽。

##### 二、技术体系
**SpringBoot**：
**SpringCloud**: Gateway 、Feign
**Spring**：Security
**Nacos**：注册中心、配置中心
**Redis**
**ElasticSearch**
**MySQL**
**Mybatis**
**Swagger**
**RabbitMQ**

辅助
**Docker**
**Nexus**
**Gitlib**


以上是主要的技术架构，其中包含了很多优化，比如HttpClient的替换等各种优化。各种技术都会有具体的实现，本项目结合电商做一个demo，大家可以基于这个做扩展。

##### 三、使用方法


##### 四、采坑记录
* 1.gateway采坑
gateway和zuul都是一样，这里两个的功能我就不过多描述。比较大的区别是gateway底层用的是webflux，zuul需要依赖 spring-boot-starter-web，web底层是servlet，所以所在使用gateway的时候需要排除spring-boot-starter-web。如果是单独的一个模块，无须引入spring-boot-starter-web即可，但是我是依赖的自己封装的basic，所以需要排除spring-boot-starter-web。

* 2.swagger采坑
在springCloud单模块的使用swagger很简单，但是作为多模块项目，这个时候怎么对前端开发人员集中展示swagger接口呢？其实只需要在gateway依赖swagger即可。本案例已经实现

* 3.docker采坑
本案例所有的中间件、已经部署都在docker中的，在docker中也踩了不少的雷，后面我环境部署完后，整理一个docker的文档，把所有的中间件下载、运行命令都集中起来。

* 4.其他
其实还有其他很多坑，比如注解使用不恰当等。。以此记录这次成长记录

##### 五、说明
该项目正在逐渐完善。。。


















