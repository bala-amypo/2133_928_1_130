package com.example.demo.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class FraudAlertRecord {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private Long claimId;
private String serialNumber;
private String alertType;
private String severity;
private String message;
private LocalDateTime alertDate;
private boolean resolved;


@PrePersist
void onCreate() {
this.alertDate = LocalDateTime.now();
this.resolved = false;
}
// getters & setters
}