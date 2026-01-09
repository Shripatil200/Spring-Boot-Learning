package com.example.bean_scope.singleton;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="singleton")
public class Singleton_Student {
    @Autowired
    Singleton_User user;

    public Singleton_Student(){
        System.out.println("Singleton_Student initialization");
    }

    @PostConstruct
    public void init() {
        System.out.println("Singleton_Student hashcode : " + this.hashCode() + "\tSingleton_User hashcode : "+ this.hashCode());
    }

}
