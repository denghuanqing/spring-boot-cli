业务网关服务

1.  负责业务转发（根据注册中心的service-id转发请求）
http://localhost:8081/item-service/item/22
http://localhost:8081/security-service/oauth/token

2.  统一鉴权，作为资源服务器。
踩坑，gateway 依赖 Spring Webflux （Netty web Server）
bug Spring cloud security 依赖Spring Boot web(tomcat Server)
所以两者不兼容,
资源服务器，单独剥离  cli-security-oauth2/resource-server