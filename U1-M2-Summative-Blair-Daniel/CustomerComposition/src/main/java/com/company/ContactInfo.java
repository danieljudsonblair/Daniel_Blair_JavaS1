package com.company;

public class ContactInfo {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNum;

    public ContactInfo(String firstName, String lastName, String email, String phoneNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void printContactInfo() {
        System.out.println("Name: " + this.getFirstName() + " " + this.getLastName());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Phone: " + this.getPhoneNum());
        System.out.println("===================");
    }
}
