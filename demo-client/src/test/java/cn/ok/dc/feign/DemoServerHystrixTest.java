package cn.ok.dc.feign;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author kyou on 2018/6/17 14:45
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoServerHystrixTest {

    @Autowired
    DemoServerRemote demoServerRemote;

    @Test
    public void getName() {
        Assert.assertEquals("", demoServerRemote.getName("userId"));
    }
}