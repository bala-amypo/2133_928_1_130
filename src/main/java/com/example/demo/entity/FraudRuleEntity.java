package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_rules")
public class FraudRuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ruleCode;

    private String ruleType;
    private String description;
    private Boolean active = true;
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public FraudRuleEntity() {}

    public Long getId() { return id; }
    public String getRuleCode() { return ruleCode; }
    public Boolean getActive() { return active; }

    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }
    public void setActive(Boolean active) { this.active = active; }

    public String getRuleType() {
    return ruleType;
}

public void setRuleType(String ruleType) {
    this.ruleType = ruleType;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

}
