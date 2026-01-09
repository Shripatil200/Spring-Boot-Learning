package com.example.bean_scope.request;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Student_Request {

    @Autowired
    User_Request user;

    public Student_Request() {
        System.out.println("Student_Request initialization");
    }

    @PostConstruct
    public void init(){
        System.out.println("Student hashcode : "+ this.hashCode()
                    + "\tUser_Request hashcode : "+ user.hashCode());
    }

}
