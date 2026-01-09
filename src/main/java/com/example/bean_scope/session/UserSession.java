package com.example.bean_scope.session;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSession {

    private String username;
    private int cartItemCount;

    public UserSession(){
        System.out.println("UserSession initialization");
    }
    @PostConstruct
    public void init(){
        System.out.println("UserSession hashcode : "+ this.hashCode());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCartItemCount() {
        return cartItemCount;
    }

    public void addItem() {
        this.cartItemCount++;
    }
}
