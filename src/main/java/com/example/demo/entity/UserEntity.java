package com.example.demo.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
public class User {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String name;


@Column(unique = true)
private String email;


private String password;


@ElementCollection(fetch = FetchType.EAGER)
private Set<String> roles;


private LocalDateTime createdAt;


@PrePersist
void onCreate() {
this.createdAt = LocalDateTime.now();
}
// getters & setters
}