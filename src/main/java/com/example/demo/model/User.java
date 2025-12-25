package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;

    // ✅ required no-arg constructor
    public User() {}

    // ✅ builder (required by MANY tests)
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final User u = new User();

        public Builder id(Long id) {
            u.id = id;
            return this;
        }

        public Builder email(String email) {
            u.email = email;
            return this;
        }

        public Builder password(String password) {
            u.password = password;
            return this;
        }

        public Builder roles(Set<String> roles) {
            u.roles = roles;
            return this;
        }

        public User build() {
            return u;
        }
    }

    // ✅ getters (CRITICAL)
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    // ✅ setters (used by services)
    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
