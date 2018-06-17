package cn.ok.ecc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kyou on 2018/6/17 14:24
 */
@Slf4j
@RestController(value = "/demo")
public class DemoController {

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
}
