package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private String claimReason;
    private String status;
    private LocalDate claimDate;

    // ✅ REQUIRED no-arg constructor
    public WarrantyClaimRecord() {
        this.status = "PENDING"; // required by test25
    }

    // ✅ getters
    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getClaimReason() {
        return claimReason;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    // ✅ setters (CRITICAL)
    public void setId(Long id) {
        this.id = id;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setClaimReason(String claimReason) {
        this.claimReason = claimReason;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }
}
