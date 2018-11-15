# spring-boot-cli
spring boot cloud architecture


- cli-eureka:注册中心
- cli-gateway:网关
```
spring boot 2.1.*与网关有冲突，采用Use Finchley and boot 2.0.x 
https://github.com/spring-cloud/spring-cloud-gateway/issues/577
gateway 整合注册中心自动转发服务：https://juejin.im/post/5b489d4be51d45198565921a
```
- cli-item-service:商品服务
- cli-order-service:订单服务
- cli-zipkin:链路追踪服务
```
spring boot 2.*后不允许不支持自定义服务，官方只提供编译好的jar包供用户使用.
 1.[jar下载地址](https://search.maven.org/remote_content?g=io.zipkin.java&a=zipkin-server&v=LATEST&c=exec)
 2.java -jar ***.jar
 3.http://localhost:9411
```
 
 


