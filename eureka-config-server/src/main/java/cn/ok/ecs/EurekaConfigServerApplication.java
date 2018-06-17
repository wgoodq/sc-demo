package cn.ok.ecs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * EnableConfigServer: 启用配置中心
 * EnableEurekaServer: 启用注册中心
 *
 * @author kyou on 2018-06-17 09:27:32
 */
@EnableConfigServer
@EnableEurekaServer
@SpringBootApplication
public class EurekaConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConfigServerApplication.class, args);
    }
}
