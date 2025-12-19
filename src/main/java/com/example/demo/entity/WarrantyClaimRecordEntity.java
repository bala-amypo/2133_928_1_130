package com.example.demo.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class WarrantyClaimRecord {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String serialNumber;
private String claimantName;
private String claimantEmail;
private String claimReason;


private LocalDateTime submittedAt;
private String status;


@PrePersist
void onCreate() {
this.submittedAt = LocalDateTime.now();
this.status = "PENDING";
}
// getters & setters
}