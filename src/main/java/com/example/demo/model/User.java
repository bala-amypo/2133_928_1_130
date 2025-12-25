package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class User {

    private Long id;
    private String email;
    private String password;
    private Set<String> roles = new HashSet<>();
    private LocalDateTime createdAt;

    public User() {
        this.roles.add("USER"); // REQUIRED by test28
        this.createdAt = LocalDateTime.now();
    }

    /* ================= GETTERS & SETTERS ================= */

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Set<String> getRoles() { return roles; }
    public void setRoles(Set<String> roles) { this.roles = roles; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    /* ================= BUILDER ================= */

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final User u = new User();

        public Builder email(String v) { u.setEmail(v); return this; }
        public Builder password(String v) { u.setPassword(v); return this; }
        public Builder roles(Set<String> v) { u.setRoles(v); return this; }

        public User build() { return u; }
    }
}
 