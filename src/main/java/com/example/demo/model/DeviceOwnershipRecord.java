package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "device_ownership")
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private String ownerName;
    private String ownerEmail;

    private Boolean active = true;
    private Boolean stolen = false;

    // 🔧 REQUIRED BY WarrantyClaimServiceImpl
    private LocalDate warrantyExpiration;

    public DeviceOwnershipRecord() {
    }

    // =====================
    // GETTERS & SETTERS
    // =====================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getStolen() {
        return stolen;
    }

    public void setStolen(Boolean stolen) {
        this.stolen = stolen;
    }

    // 🔧 FIX FOR COMPILATION ERROR
    public LocalDate getWarrantyExpiration() {
        return warrantyExpiration;
    }

    public void setWarrantyExpiration(LocalDate warrantyExpiration) {
        this.warrantyExpiration = warrantyExpiration;
    }

    // =====================
    // BUILDER (TEST SUPPORT)
    // =====================

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final DeviceOwnershipRecord record = new DeviceOwnershipRecord();

        public Builder id(Long id) {
            record.setId(id);
            return this;
        }

        public Builder serialNumber(String serialNumber) {
            record.setSerialNumber(serialNumber);
            return this;
        }

        public Builder ownerName(String ownerName) {
            record.setOwnerName(ownerName);
            return this;
        }

        public Builder ownerEmail(String ownerEmail) {
            record.setOwnerEmail(ownerEmail);
            return this;
        }

        public Builder active(Boolean active) {
            record.setActive(active);
            return this;
        }

        public Builder stolen(Boolean stolen) {
            record.setStolen(stolen);
            return this;
        }

        // 🔧 REQUIRED BY WARRANTY CLAIM TESTS
        public Builder warrantyExpiration(LocalDate warrantyExpiration) {
            record.setWarrantyExpiration(warrantyExpiration);
            return this;
        }

        public DeviceOwnershipRecord build() {
            return record;
        }
    }
}
