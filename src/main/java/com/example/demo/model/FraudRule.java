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

    /* ===== REQUIRED BY TESTS ===== */
    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    /* ===== BUILDER ===== */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final FraudRule r = new FraudRule();

        public Builder id(Long id) {
            r.setId(id);
            return this;
        }

        public Builder ruleCode(String ruleCode) {
            r.setRuleCode(ruleCode);
            return this;
        }

        public Builder ruleType(String ruleType) {
            r.setRuleType(ruleType);
            return this;
        }

        public Builder description(String description) {
            r.setDescription(description);
            return this;
        }

        public Builder active(boolean active) {
            r.setActive(active);
            return this;
        }

        public FraudRule build() {
            return r;
        }
    }

    /* ===== GETTERS / SETTERS ===== */

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

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

    /* 🔑 CRITICAL PART (FIX) */

    // Used by Hibernate / JavaBeans
    public boolean isActive() {
        return active;
    }

    // Used by Service + TestNG
    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
