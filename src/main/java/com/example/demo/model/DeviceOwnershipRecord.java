package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "device_ownership_records",
    uniqueConstraints = @UniqueConstraint(columnNames = "serialNumber")
)
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String serialNumber;

    @Column(nullable = false)
    private String ownerName;

    private String ownerEmail;

    private LocalDate purchaseDate;

    @Column(nullable = false)
    private LocalDate warrantyExpiration;

    @Column(nullable = false)
    private Boolean active = true;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public DeviceOwnershipRecord() {
    }

    public DeviceOwnershipRecord(String serialNumber, String ownerName, String ownerEmail,
                                 LocalDate purchaseDate, LocalDate warrantyExpiration) {
        this.serialNumber = serialNumber;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.purchaseDate = purchaseDate;
        this.warrantyExpiration = warrantyExpiration;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.active == null) {
            this.active = true;
        }
    }

    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public LocalDate getWarrantyExpiration() {
        return warrantyExpiration;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    public boolean isEmpty() {
    return this.serialNumber == null || this.serialNumber.isBlank();
}

}
