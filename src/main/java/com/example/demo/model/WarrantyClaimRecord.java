package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private String claimReason;


    private String status = "SUBMITTED";

    public WarrantyClaimRecord() {
        this.status = "SUBMITTED";
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getClaimReason() {
    return claimReason;
}
public static Builder builder() {
    return new Builder();
}

public static class Builder {
    private final WarrantyClaimRecord record = new WarrantyClaimRecord();

    public Builder serialNumber(String serial) {
        record.setSerialNumber(serial);
        return this;
    }

    public Builder claimantName(String name) {
        record.setClaimantName(name);
        return this;
    }

    public Builder claimantEmail(String email) {
        record.setClaimantEmail(email);
        return this;
    }

    public Builder claimReason(String reason) {
        record.setClaimReason(reason);
        return this;
    }

    public Builder status(String status) {
        record.setStatus(status);
        return this;
    }

    public Builder submittedAt(java.time.LocalDateTime time) {
        record.setSubmittedAt(time);
        return this;
    }

    public WarrantyClaimRecord build() {
        return record;
    }
}


}
