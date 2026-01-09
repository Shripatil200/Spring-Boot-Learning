package com.example.bean_scope.request;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
@Scope(value="singleton")
public class TestRequestController {

    @Autowired
    User_Request user;

    @Autowired
    Student_Request student;

    public TestRequestController(){
        System.out.println("TestRequestController initialization");
    }

    @PostConstruct
    public void init(){
        System.out.println("TestRequestController hashcode : "+ this.hashCode()
               + "\tUser_Request hashcode : "+ user.hashCode()
                + "\tStudentRequest hashcode : "+ student.hashCode());
    }

    @GetMapping("fetchUser")
    public ResponseEntity<String> getUserDetails(){
        System.out.println("fetch api called");
        user.init();
        return ResponseEntity.status(HttpStatus.OK).body("");
    }



}
