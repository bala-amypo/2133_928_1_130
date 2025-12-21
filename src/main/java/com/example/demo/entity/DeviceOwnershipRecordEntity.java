package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DeviceOwnershipRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serialNumber;

    private String ownerName;
    private LocalDate purchaseDate;
    private LocalDate warrantyEndDate;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public LocalDate getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }

    public LocalDate getWarrantyEndDate() { return warrantyEndDate; }
    public void setWarrantyEndDate(LocalDate warrantyEndDate) { this.warrantyEndDate = warrantyEndDate; }
}
