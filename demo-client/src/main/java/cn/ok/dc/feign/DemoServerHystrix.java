package cn.ok.dc.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 如果远程服务无法被访问到，熔断器捕获到调用异常自动触发熔断器熔断机制，当触发器处于熔断状态时，熔断器将自动回调相应的函数，进行服务调用异常处理。
 * 熔断器处于熔断状态一定时间后，熔断器自动终止熔断状态，服务调用将以正常形式进行，假如服务仍未恢复，熔断器将再次进入熔断状态。
 *
 * @author kyou on 2018/6/17 10:46
 */
@Slf4j
@Component
public class DemoServerHystrix implements DemoServerRemote {

    /**
     * 获取用户名时触发熔断器，以未查询到用户名处置。
     *
     * @param id 用户 id
     * @return 用户名
     */
    @Override
    public String getName(String id) {
        log.error("通过用户ID，查询用户名时触发熔断器。用户ID：'{}'，返回用户名：'{}'。", id, "");
        return "";
    }
}
