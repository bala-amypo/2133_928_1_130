package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stolen_device_reports")
public class StolenDeviceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private String reportedBy;
    private String details;
    private LocalDateTime reportDate;

    public StolenDeviceReport() {}

    public void setId(long id) { this.id = id; }
    public Long getId() { return id; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final StolenDeviceReport r = new StolenDeviceReport();

        public Builder id(Long id) { r.setId(id); return this; }
        public Builder serialNumber(String s) { r.setSerialNumber(s); return this; }
        public Builder reportedBy(String s) { r.setReportedBy(s); return this; }
        public StolenDeviceReport build() { return r; }
    }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getReportedBy() { return reportedBy; }
    public void setReportedBy(String reportedBy) { this.reportedBy = reportedBy; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public LocalDateTime getReportDate() { return reportDate; }
    public void setReportDate(LocalDateTime reportDate) { this.reportDate = reportDate; }
}
