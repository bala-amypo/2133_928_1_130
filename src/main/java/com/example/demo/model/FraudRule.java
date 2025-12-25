package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_rules")
public class FraudRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleCode;
    private String ruleType;
    private String description;
    private boolean active;
    private LocalDateTime createdAt;

    public FraudRule() {}

    public void setId(long id) { this.id = id; }
    public Long getId() { return id; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final FraudRule r = new FraudRule();

        public Builder id(Long id) { r.setId(id); return this; }
        public Builder ruleCode(String s) { r.setRuleCode(s); return this; }
        public Builder ruleType(String s) { r.setRuleType(s); return this; }
        public FraudRule build() { return r; }
    }

    public String getRuleCode() { return ruleCode; }
    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }

    public String getRuleType() { return ruleType; }
    public void setRuleType(String ruleType) { this.ruleType = ruleType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
