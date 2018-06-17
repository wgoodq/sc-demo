package cn.ok.dc.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * RskRemote是被注册到Eureka的服务的映射接口。
 * Feign注解的name属性表示被调用方应用名称（spring.application.name设定的名称）
 * Feign注解的fallback属性指定当远程服务无法访问时，执行异常处理的类（即熔断器回调函数）。
 *
 * @author kyou on 2018/6/17 10:44
 */
@FeignClient(name = "demo-server", fallback = DemoServerHystrix.class)
public interface DemoServerRemote {

    /**
     * 获取用户名
     *
     * @param id 用户 id
     * @return 用户名
     */
    @GetMapping("/getName/{id}")
    public String getName(@PathVariable("id") String id);
}
