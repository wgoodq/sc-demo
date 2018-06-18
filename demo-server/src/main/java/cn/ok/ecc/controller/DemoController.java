package cn.ok.ecc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 本项目第一次启动后，会从配置中心读取配置信息。
 * 当配置中心的配置信息发生变动后，可以通过post方式访问http://127.0.0.1:2101/actuator/refresh/的方式
 * （在Linux服务器：curl -X POST http://127.0.0.1:2101/actuator/refresh/）<= 注意：POST 全大写，在我本地127.0.0.1正常，换成 localhost 就不正常。
 * 刷新被RefreshScope注解标注的类中的配置信息。
 *
 * @author kyou on 2018/6/17 14:24
 */
@Slf4j
@RefreshScope
@RestController
public class DemoController {

    /**
     * 从配置中心读取配置文件信息
     */
    @Value("${cn.ok.name}")
    private String name;

    @GetMapping("/getName/{id}")
    public String getName(@PathVariable("id") String id) {

        String rtnName;
        switch (id.toUpperCase()) {
            case "aa":
                rtnName = "John";
                break;
            case "11":
                rtnName = "Jobs";
                break;
            default:
                rtnName = "";
        }

        log.info("Get User Name: '{}', with id: '{}'", rtnName, id);
        return rtnName;
    }

    @GetMapping("sayHi")
    public String sayHello() {
        return "hi " + name;
    }
}
