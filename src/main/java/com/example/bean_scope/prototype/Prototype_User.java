package com.example.bean_scope.prototype;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Prototype_User {

    public Prototype_User(){
        System.out.println("Prototype_User initialization");
    }

    @PostConstruct
    public void init(){
        System.out.println("Prototype_User hashcode : "+ this.hashCode());
    }
}
