package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "device_ownership_records")
public class DeviceOwnershipRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String serialNumber;

    private String ownerName;
    private String ownerEmail;
    private LocalDate purchaseDate;
    private LocalDate warrantyExpiration;
    private Boolean active = true;
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public DeviceOwnershipRecordEntity() {}

    public Long getId() { return id; }
    public String getSerialNumber() { return serialNumber; }
    public LocalDate getWarrantyExpiration() { return warrantyExpiration; }
    public Boolean getActive() { return active; }

    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    public void setActive(Boolean active) { this.active = active; }
}
