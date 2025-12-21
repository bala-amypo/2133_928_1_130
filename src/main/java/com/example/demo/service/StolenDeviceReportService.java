package com.example.demo.service;

import com.example.demo.entity.StolenDeviceReportEntity;
import java.util.List;

@Service
public interface StolenDeviceReportService {

    StolenDeviceReportEntity reportStolen(StolenDeviceReportEntity report);

    List<StolenDeviceReportEntity> getReportsBySerial(String serialNumber);

    StolenDeviceReportEntity getReportById(Long id);

    List<StolenDeviceReportEntity> getAllReports();
}
