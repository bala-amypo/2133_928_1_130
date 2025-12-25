package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_alert_records")
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long claimId;
    private String serialNumber;
    private String alertType;
    private String severity;
    private boolean resolved;
    private String message;
    private LocalDateTime alertDate;

    public FraudAlertRecord() {}

    /* ================= REQUIRED BY TESTS ================= */

    public static Builder builder() {
        return new Builder();
    }

    public boolean getResolved() {
        return resolved;
    }

    public void setId(long id) {
        this.id = id;
    }

    /* ================= BUILDER ================= */

    public static class Builder {
        private final FraudAlertRecord f = new FraudAlertRecord();

        public Builder id(Long id) {
            f.setId(id);
            return this;
        }

        public Builder claimId(Long claimId) {
            f.setClaimId(claimId);
            return this;
        }

        public Builder serialNumber(String serialNumber) {
            f.setSerialNumber(serialNumber);
            return this;
        }

        public Builder alertType(String alertType) {
            f.setAlertType(alertType);
            return this;
        }

        public Builder severity(String severity) {
            f.setSeverity(severity);
            return this;
        }

        public Builder resolved(boolean resolved) {
            f.setResolved(resolved);
            return this;
        }

        public Builder message(String message) {
            f.setMessage(message);
            return this;
        }

        public Builder alertDate(LocalDateTime alertDate) {
            f.setAlertDate(alertDate);
            return this;
        }

        public FraudAlertRecord build() {
            return f;
        }
    }

    /* ================= GETTERS & SETTERS ================= */

    public Long getId() { return id; }

    public Long getClaimId() { return claimId; }
    public void setClaimId(Long claimId) { this.claimId = claimId; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getAlertType() { return alertType; }
    public void setAlertType(String alertType) { this.alertType = alertType; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public boolean isResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getAlertDate() { return alertDate; }
    public void setAlertDate(LocalDateTime alertDate) { this.alertDate = alertDate; }
}
