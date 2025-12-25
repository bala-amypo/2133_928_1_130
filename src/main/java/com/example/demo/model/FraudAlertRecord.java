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
    private String message;
    private boolean resolved;
    private LocalDateTime alertDate;

    public FraudAlertRecord() {}

    public void setId(long id) { this.id = id; }
    public Long getId() { return id; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final FraudAlertRecord r = new FraudAlertRecord();

        public Builder id(Long id) { r.setId(id); return this; }
        public Builder serialNumber(String s) { r.setSerialNumber(s); return this; }
        public Builder severity(String s) { r.setSeverity(s); return this; }
        public FraudAlertRecord build() { return r; }
    }

    public Long getClaimId() { return claimId; }
    public void setClaimId(Long claimId) { this.claimId = claimId; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getAlertType() { return alertType; }
    public void setAlertType(String alertType) { this.alertType = alertType; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public boolean isResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }

    public LocalDateTime getAlertDate() { return alertDate; }
    public void setAlertDate(LocalDateTime alertDate) { this.alertDate = alertDate; }
}
