package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_alert_records")
public class FraudAlertRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long claimId;
    private String serialNumber;
    private String alertType;
    private String severity;
    private String message;
    private Boolean resolved = false;
    private LocalDateTime alertDate;

    @PrePersist
    void onCreate() {
        alertDate = LocalDateTime.now();
    }

    public FraudAlertRecordEntity() {}

    // getters & setters
}
