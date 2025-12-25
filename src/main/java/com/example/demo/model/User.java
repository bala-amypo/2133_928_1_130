package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private LocalDateTime createdAt;

    @ElementCollection
    private Set<String> roles;

    public User() {}

    // REQUIRED BY TESTS
    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    // REQUIRED BUILDER
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final User u = new User();

        public Builder id(Long id) {
            u.setId(id);
            return this;
        }

        public Builder name(String name) {
            u.setName(name);
            return this;
        }

        public Builder email(String email) {
            u.setEmail(email);
            return this;
        }

        public Builder password(String password) {
            u.setPassword(password);
            return this;
        }

        public Builder roles(Set<String> roles) {
            u.setRoles(roles);
            return this;
        }

        public User build() {
            return u;
        }
    }

    // GETTERS / SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
