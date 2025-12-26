package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "device_ownership_records")
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private String ownerName;
    private String ownerEmail;
    private LocalDate purchaseDate;
    private LocalDate warrantyExpiration;
    private boolean active;
    private LocalDateTime createdAt;
    // ADD this field with other fields
    private boolean stolen;


    public DeviceOwnershipRecord() {}

    public void setId(long id) { this.id = id; }
    public Long getId() { return id; }

    /* ===== REQUIRED BY TESTS ===== */

    public static Builder builder() {
        return new Builder();
    }

    public boolean isEmpty() {
        return serialNumber == null || serialNumber.isEmpty();
    }

    public boolean getActive() {
        return active;
    }

    public static class Builder {
        private final DeviceOwnershipRecord d = new DeviceOwnershipRecord();

        public Builder id(Long id) { d.setId(id); return this; }
        public Builder serialNumber(String v) { d.setSerialNumber(v); return this; }
        public Builder ownerName(String v) { d.setOwnerName(v); return this; }
        public Builder ownerEmail(String v) { d.setOwnerEmail(v); return this; }
        public Builder purchaseDate(LocalDate v) { d.setPurchaseDate(v); return this; }
        public Builder warrantyExpiration(LocalDate v) { d.setWarrantyExpiration(v); return this; }
        public Builder active(boolean v) { d.setActive(v); return this; }

        public DeviceOwnershipRecord build() { return d; }
    }

    /* ===== GETTERS / SETTERS ===== */

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getOwnerEmail() { return ownerEmail; }
    public void setOwnerEmail(String ownerEmail) { this.ownerEmail = ownerEmail; }

    public LocalDate getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }

    public LocalDate getWarrantyExpiration() { return warrantyExpiration; }
    public void setWarrantyExpiration(LocalDate warrantyExpiration) { this.warrantyExpiration = warrantyExpiration; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    // ADD this method at the bottom of the class
    public void setStolen(boolean stolen) {
        this.stolen = stolen;
}
    public boolean isStolen() {
    return stolen;
}

public void setStolen(boolean stolen) {
    this.stolen = stolen;
}


}
