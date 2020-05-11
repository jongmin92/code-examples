package com.jongmin.springcore;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Getter;

@Getter
public class LifeCycleService implements InitializingBean, DisposableBean {

    private int afterPropertiesValue;
    private int initValue;

    private int destroyValue;
    private int cleanUpValue;

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
}
