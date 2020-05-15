package com.jongmin.springcore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BasicDataSource {

    private String driverClassName;
    private String url;
    private String username;
    private String password;
}
