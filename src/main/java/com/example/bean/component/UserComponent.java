package com.example.bean.component;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class UserComponent {

    private String name;
    private int age;

    public UserComponent(){
        /*We must create default constructor if we have any parameterized constructor in our class.*/
    }

    public UserComponent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @PostConstruct
    public void init(){
        System.out.println("UserComponent initialization");
    }
}
