package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class FraudRuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ruleName;

    private String description;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
