package com.example.bean_scope.singleton;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class TestSingletonController {

    @Autowired
    Singleton_User user;

    @Autowired
    Singleton_Student student;

    public TestSingletonController(){
        System.out.println("TestSingletonController initialization");
    }

    @PostConstruct
    public void init(){
        System.out.println("TestSingletonController hashcode : "+ this.hashCode()
                + "\tSingleton_User hashcode : "+ user.hashCode()
                +"Singleton_Student hashcode : " + student.hashCode());
    }

    @GetMapping("/fetchUserSingleton")
    public ResponseEntity<String> getUserDetails(){
        System.out.println("fetch api invoked");
        return ResponseEntity.ok("");
    }

}
