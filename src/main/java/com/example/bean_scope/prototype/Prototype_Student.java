package com.example.bean_scope.prototype;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Prototype_Student {

    @Autowired
    Prototype_User user;

    public Prototype_Student(){
        System.out.println("Prototype_Student initialization");
    }

    @PostConstruct
    public void inti(){
        System.out.println("Prototype_Student hashcode : "+ this.hashCode() + "\tPrototype_User hashcode : "+ user.hashCode());
    }
}
