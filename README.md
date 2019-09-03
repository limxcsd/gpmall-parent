# gpmall-parent

#### 介绍
咕泡商城是咕泡学院 Java架构课程中，帮助学员对于技术更好落地的一个实战项目，项目基于springboot2.1.6.RELEASE+Dubbo2.7.3 来构建微服务。

## 后端使用的技术

后端的主要架构是基于springboot+dubbo+mybatis.

* SpringBoot2.1.6
* Mybatis
* Dubbo2.7.2
* Zookeeper
* Mysql
* Redis
* Elasticsearch
* Kafka
* druid
* Docker
* mybatis generator
* Sentinel


# 项目模块说明

| db_script  本项目的数据库脚本                                | 使用mysql | 暂时未做分表处理，不过有考虑到分表的情况             |
| ------------------------------------------------------------ | --------- | ---------------------------------------------------- |
| gpmall-commons 公共的组件                                    | jar       | 公共组件         |
| gpmall-front  商城的前端项目                             | 前端项目  | 使用vue、node、es等前端技术开发                      |
| gpmall-parent 父控文件，用来统一管理所有jar包                | 父控文件  | 用来统一管理所有项目的jar包的版本                    |
| gpmall-provider-pay  提供支付处理能力                                | dubbo服务 | 20883端口                                            |
| gpmall-provider-shopping，提供购物车、推荐商品、商品等服务           | dubbo服务 | 20881端口                                            |
| gpmall-provider-user ，提供用户相关服务                              | dubbo服务 | 20880端口                                            |
| gpmall-provider-order ，提供订单服务                                 | dubbo服务 | 20882端口                                            |
| gpmall-user-web 提供用户相关的交互                | web项目   | 8083端口                                             |
| gpmall-shopping-web 商品/购物车/首页渲染等交互                | web项目   | 8083端口                                             |



#### 使用说明

1. xxxx
2. xxxx
3. xxxx

#### 参与贡献

1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request

