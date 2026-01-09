package com.example.bean_scope.singleton;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Singleton_User {

    public Singleton_User(){
        System.out.println("Singleton_User initialization");
    }

    @PostConstruct
    public void init(){
        System.out.println("Singleton_User hashcode : " + this.hashCode());
    }

}
