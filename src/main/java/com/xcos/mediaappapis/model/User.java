package com.xcos.mediaappapis.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(value = "users_data")
public class User {
    @Id
    private String id;
    @Size(min = 2, message = "Name should be at-least two characters")
    private String name;


    @JsonIgnore
    @NotBlank(message = "Password field is required")
    private String password;
    @NotBlank
    private String  localDate;

    private Photo photo;

    @JsonIgnore
    List<Post> postList;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String id, String name, String localDate, List<Post> postList, String password, Photo photo) {
        this.id = id;
        this.name = name;
        this.localDate = localDate;
        this.postList = postList;
        this.password = password;
        this.photo = photo;
    }

    public User() {

    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", localDate=" + localDate +
                ", postList=" + postList +
                '}';
    }
}
