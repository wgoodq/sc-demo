package cn.ok.dc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * EnableFeignClients: 启用Feign组件，利用Feign调用被注册到Eureka（注册中心）的服务。Feign内部集成了Ribbon，实现了负载均衡。（存疑）
 * EnableDiscoveryClient: 启用服务注册与发现。
 *
 * @author kyou
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}
