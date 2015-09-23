package com.antogeo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "User")
public class User {

    private long userId;
    private String username;
    private String password;
    private Set<Message> messagesSent = new HashSet<>();


    public User() {
    }

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sender")
    public Set<Message> getMessagesSent() {
        return messagesSent;
    }

    public void setMessagesSent(Set<Message> messagesSent) {
        this.messagesSent = messagesSent;
    }
}