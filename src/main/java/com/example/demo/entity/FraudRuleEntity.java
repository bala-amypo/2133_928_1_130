package com.example.demo.model;


import jakarta.persistence.*;


@Entity
public class FraudRule {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(unique = true)
private String ruleCode;


private String description;
private String ruleType;
private boolean active;
// getters & setters
}