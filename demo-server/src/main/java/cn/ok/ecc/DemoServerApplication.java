package cn.ok.ecc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * EnableDiscoveryClient: 启用服务注册与发现。
 * RestController: 对外提供 Rest 接口服务
 *
 * @author kyou on 2018-06-17 09:32:38
 */
@EnableDiscoveryClient
@SpringBootApplication
public class DemoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoServerApplication.class, args);
    }
}
