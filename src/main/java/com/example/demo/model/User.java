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
    private LocalDateTime createdAt = LocalDateTime.now();

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;

    public User() {}

    /* ===== REQUIRED BY TESTS ===== */
    public void setId(long id) { this.id = id; }
    public Long getId() { return id; }
    public Set<String> getRoles() { return roles; }
    public String getPassword() { return password; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final User u = new User();

        public Builder id(Long id) {
            u.id = id;
            return this;
        }

        public Builder name(String n) {
            u.name = n;
            return this;
        }

        public Builder email(String e) {
            u.email = e;
            return this;
        }

        public Builder password(String p) {
            u.password = p;
            return this;
        }

        public Builder roles(Set<String> r) {
            u.roles = r;
            return this;
        }

        public User build() {
            return u;
        }
    }
}
