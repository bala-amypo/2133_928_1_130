package com.example.demo.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class StolenDeviceReport {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String serialNumber;
private String reportedBy;
private LocalDateTime reportDate;
private String details;


@PrePersist
void onCreate() {
this.reportDate = LocalDateTime.now();
}
// getters & setters
}