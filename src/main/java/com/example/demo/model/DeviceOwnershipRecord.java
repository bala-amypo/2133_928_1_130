package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "device_ownership")
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String serialNumber;

    private boolean active = true;

    private boolean stolen = false;

    private LocalDate warrantyExpiration;

    /* =========================
       CONSTRUCTORS
       ========================= */

    public DeviceOwnershipRecord() {
    }

    public DeviceOwnershipRecord(String serialNumber, LocalDate warrantyExpiration) {
        this.serialNumber = serialNumber;
        this.warrantyExpiration = warrantyExpiration;
        this.active = true;
        this.stolen = false;
    }

    /* =========================
       GETTERS
       ========================= */

    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public boolean getActive() {
        return active;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isStolen() {
        return stolen;
    }

    public LocalDate getWarrantyExpiration() {
        return warrantyExpiration;
    }

    /* =========================
       SETTERS
       ========================= */

    public void setId(Long id) {
        this.id = id;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setStolen(boolean stolen) {
        this.stolen = stolen;
    }

    public void setWarrantyExpiration(LocalDate warrantyExpiration) {
        this.warrantyExpiration = warrantyExpiration;
    }
}
