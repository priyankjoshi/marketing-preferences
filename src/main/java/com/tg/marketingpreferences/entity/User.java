package com.tg.marketingpreferences.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="user")
public class User {

    @Id
    @Column(name="id")
    private Long id;

    @Column(name="Username")
    private String userName;

    public User() {
    }

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Post> userPost = new HashSet<>();

    public User(Long id, String userName){
        this.id = id;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Post> getUserPost() {
        return userPost;
    }

    public void setUserPost(Set<Post> userPost) {
        this.userPost = userPost;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
