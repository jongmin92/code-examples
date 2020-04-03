package com.jongmin.mechanism;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class MechanismStudyApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MechanismStudyApplication.class);
        application.addListeners(new ApplicationListener<WebServerInitializedEvent>() {
            @Override
            public void onApplicationEvent(WebServerInitializedEvent event) {
                log.info("Server Port from WebServerInitializedEvent : {}",
                         event.getApplicationContext().getWebServer().getPort());
            }
        });

        application.run(args);
    }

}
