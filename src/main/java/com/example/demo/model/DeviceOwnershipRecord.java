package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private String ownerName;

    private boolean stolen;
    private boolean active = true;   // ✅ ADDED (default true)

    private LocalDate warrantyExpiration;

    public DeviceOwnershipRecord() {}

    // ===== GETTERS / SETTERS =====

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

    public boolean isStolen() {
        return stolen;
    }

    public void setStolen(boolean stolen) {
        this.stolen = stolen;
    }

    // ✅ REQUIRED BY DeviceOwnershipServiceImpl
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getWarrantyExpiration() {
        return warrantyExpiration;
    }

    public void setWarrantyExpiration(LocalDate warrantyExpiration) {
        this.warrantyExpiration = warrantyExpiration;
    }

    // ===== TEST HELPERS =====

    public boolean isEmpty() {
        return serialNumber == null || serialNumber.isBlank();
    }

    // ===== BUILDER (TEST REQUIRED) =====

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final DeviceOwnershipRecord d = new DeviceOwnershipRecord();

        public Builder id(Long id) {
            d.setId(id);
            return this;
        }

        public Builder serialNumber(String serial) {
            d.setSerialNumber(serial);
            return this;
        }

        public Builder ownerName(String owner) {
            d.setOwnerName(owner);
            return this;
        }

        public Builder stolen(boolean stolen) {
            d.setStolen(stolen);
            return this;
        }

        public Builder active(boolean active) {
            d.setActive(active);
            return this;
        }

        public Builder warrantyExpiration(LocalDate date) {
            d.setWarrantyExpiration(date);
            return this;
        }

        public DeviceOwnershipRecord build() {
            return d;
        }
    }
}
