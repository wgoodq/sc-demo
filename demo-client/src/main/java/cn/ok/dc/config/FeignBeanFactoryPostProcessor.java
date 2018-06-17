package cn.ok.dc.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 解决单元测试终止时一个警告，详见: https://github.com/spring-cloud/spring-cloud-netflix/issues/1952
 *
 * @author kyou on 2018-06-17 15:26:47
 */
@Component
public class FeignBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String feignContext = "feignContext";
        String eurekaAutoServiceRegistration = "eurekaAutoServiceRegistration";
        if (containsBeanDefinition(beanFactory, feignContext, eurekaAutoServiceRegistration)) {
            BeanDefinition bd = beanFactory.getBeanDefinition("feignContext");
            bd.setDependsOn("eurekaAutoServiceRegistration");
        }
    }

    private boolean containsBeanDefinition(ConfigurableListableBeanFactory beanFactory, String... beans) {
        return Arrays.stream(beans).allMatch(beanFactory::containsBeanDefinition);
    }
}