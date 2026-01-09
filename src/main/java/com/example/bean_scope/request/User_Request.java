package com.example.bean_scope.request;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User_Request {

    public User_Request(){
        System.out.println("User_Request initialization");
    }

    @PostConstruct
    public void init(){
        System.out.println("User_Request hashcode : "+ this.hashCode());
    }
}
