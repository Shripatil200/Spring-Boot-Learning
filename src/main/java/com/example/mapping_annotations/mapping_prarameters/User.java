package com.example.mapping_annotations.mapping_prarameters;

import java.util.Date;

public class User {
    private String name;
    private String address;
    private Date dob;
    private int age;

    public User() {
    }

    public User(String name, String address, Date dob, int age) {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
