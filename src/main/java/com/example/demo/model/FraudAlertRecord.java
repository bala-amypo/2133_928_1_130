package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_alert_records")
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long claimId;

    @Column(nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private String alertType;

    @Column(nullable = false)
    private String severity;

    private String message;

    @Column(nullable = false)
    private Boolean resolved = false;

    @Column(nullable = false)
    private LocalDateTime alertDate;

    public FraudAlertRecord() {
    }

    public FraudAlertRecord(Long claimId, String serialNumber,
                            String alertType, String severity, String message) {
        this.claimId = claimId;
        this.serialNumber = serialNumber;
        this.alertType = alertType;
        this.severity = severity;
        this.message = message;
    }

    @PrePersist
    public void onCreate() {
        this.alertDate = LocalDateTime.now();
        if (this.resolved == null) {
            this.resolved = false;
        }
    }

    public Long getId() {
        return id;
    }

    public Long getClaimId() {
        return claimId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
