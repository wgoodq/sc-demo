package cn.ok.dc.controller;

import cn.ok.dc.feign.DemoServerRemote;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * RskRemote是Feign接口，此处通过RskRemote来调用注册中心的服务。
 *
 * @author kyou on 2018/6/17 10:50
 */
@Slf4j
@RestController
public class DemoController {

    private final DemoServerRemote demoServerRemote;

    @Autowired
    public DemoController(DemoServerRemote demoServerRemote) {
        this.demoServerRemote = demoServerRemote;
    }

    @GetMapping("/getName/{id}")
    public String getName(@PathVariable("id") String id) {
        log.info("Calling http://demo-server/demo/getName/{id}.");

        String userName = demoServerRemote.getName(id);
        if (Strings.isNullOrEmpty(userName)) {
            return "Can not find this user. (ID:'" + id + "')";
        } else {
            return userName;
        }
    }
}
