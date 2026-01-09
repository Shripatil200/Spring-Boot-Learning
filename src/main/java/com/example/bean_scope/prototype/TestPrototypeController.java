package com.example.bean_scope.prototype;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestPrototypeController {

    @Autowired
    Prototype_User user;

    @Autowired
    Prototype_Student student;

    TestPrototypeController(){
        System.out.println("TestPrototypeController initialization");
    }

    @PostConstruct
    public void init(){
        System.out.println("TestPrototypeController hashcode: "+ this.hashCode()
                + "\tPrototype_User hashcode: "+ user.hashCode()
                + "\tPrototype_Student hashcode: "+ student.hashCode());
    }

    @GetMapping("/fetchUserDetailsPrototype")
    public ResponseEntity<String> getUserDetails(){
        System.out.println("fetch api invoked");
        return ResponseEntity.ok(" ");
    }

}
