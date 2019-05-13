### 一、功能描述
该工程主要作为一个工具工程使用，目的是通过mybatis generate自动生成对应的controller、service、domain、mapper、xml，简化工作量

### 二、使用方法
* 第一步：修改自定义配置一: com/framework/generator/MybatisGenerator.java:23,把目录修改成当前目录
* 第二步：修改自定义配置二: com/framework/generator/MybatisGenerator.java:63,修改数据表前缀同时添加需要反向生成的数据表
* 第三步：修改自定义配置三: com/framework/generator/MybatisGenerator.java:94, 把目录换成自己项目目录
* 第四步: 启动main方法
* 第五步: 在生成的Entity中,删除多余的
 @EqualsAndHashCode(callSuper = true)
 @Accessors(chain = true)
 private static final long serialVersionUID=1L;
最后复制到自己的项目中即可
