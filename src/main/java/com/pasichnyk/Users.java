package com.pasichnyk;

public class Users {

    private int id;
    private String username;
    private String userPassword;
    private String emailAddress;
    private int age;

    public Users(int id, String username, String userPassword, String emailAddress, int age) {
        this.id = id;
        this.username = username;
        this.userPassword = userPassword;
        this.emailAddress = emailAddress;
        this.age = age;
    }

    @Override
    public String toString() {
        return "com.pasichnyk.Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", user_password='" + userPassword + '\'' +
                ", email_address='" + emailAddress + '\'' +
                ", age=" + age +
                '}';
    }
}
