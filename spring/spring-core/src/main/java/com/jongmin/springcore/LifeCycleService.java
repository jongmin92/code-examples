package com.jongmin.springcore;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import lombok.Getter;

@Getter
public class LifeCycleService implements InitializingBean, DisposableBean, ApplicationContextAware,
                                         BeanNameAware {

    private int afterPropertiesValue;
    private int initValue;

    private int destroyValue;
    private int cleanUpValue;

    private ApplicationContext context;
    private String beanName;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
        afterPropertiesValue = 100;
    }

    public void init() {
        System.out.println("init");
        initValue = 300;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
        destroyValue = -100;
    }

    public void cleanUp() {
        System.out.println("cleanUp");
        cleanUpValue = -300;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    @Override
    public void setBeanName(String name) {
        beanName = name;
    }
}
