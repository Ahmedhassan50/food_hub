package com.example.foodhub.data.model;

import com.google.gson.annotations.SerializedName;

public class User {
    private String id;
    private String email;
    @SerializedName("pass")
    private String password;
    private String name;
    private String mobile;
    @SerializedName("pic")
    private String image;
    private String blocked;


    public User(String id, String email, String password, String name, String mobile, String image, String blocked) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.mobile = mobile;
        this.image = image;
        this.blocked = blocked;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getImage() {
        return image;
    }

    public String getBlocked() {
        return blocked;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", image='" + image + '\'' +
                ", blocked='" + blocked + '\'' +
                '}';
    }
}
