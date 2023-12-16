package com.xcos.mediaappapis.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Document(value = "posts_data")
public class Post {

    @Id
    private String id;
    @NonNull
    @Size(min = 10,message = "Enter at-least 10 characters")
    @NotBlank
    private String description;
    private User user;

    public Post(String id, @NonNull String description, User user) {
        this.id = id;
        this.description = description;
        this.user = user;
    }

    public Post() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
