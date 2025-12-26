package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;

    private boolean active;

    private boolean stolen;
    private LocalDate warrantyExpiration;

public LocalDate getWarrantyExpiration() {
    return warrantyExpiration;
}


    public DeviceOwnershipRecord() {
    }

    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isStolen() {
        return stolen;
    }

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
    getWarrantyExpiration()

}
