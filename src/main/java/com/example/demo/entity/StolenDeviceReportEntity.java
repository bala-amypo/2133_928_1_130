package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stolen_device_reports")
public class StolenDeviceReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String serialNumber;

    private String reportedBy;
    private String details;
    private LocalDateTime reportDate;

    @PrePersist
    void onCreate() {
        reportDate = LocalDateTime.now();
    }

    public StolenDeviceReportEntity() {}

    // getters & setters
}
