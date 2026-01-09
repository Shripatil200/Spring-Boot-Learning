package com.example.bean_scope.session;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSessionController {

    private final UserSession userSession;

    public TestSessionController(UserSession userSession) {
        this.userSession = userSession;
        System.out.println("TestSessionController initialization");
    }

    @PostConstruct
    public void init() {
        System.out.println("TestSessionController hashcode :"+ this.hashCode()
                        + "\tuserSession hashcode :"+ userSession.hashCode());
    }

    @GetMapping("/login")
    public String login() {
        userSession.setUsername("shriram");
        System.out.println("Login api invoked. \t userSession hashCode :" + userSession.hashCode());
        userSession.init();
        return "User logged in: " + userSession.getUsername();
    }

    @GetMapping("/add-to-cart")
    public String addToCart() {
        userSession.addItem();
        return "Cart items: " + userSession.getCartItemCount();
    }
}


