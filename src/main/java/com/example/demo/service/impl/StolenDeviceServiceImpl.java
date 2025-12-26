package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository stolenDeviceReportRepository;

    /**
     * ✔ REQUIRED constructor for Spring
     * ✔ Does NOT remove any existing logic
     * ✔ Fixes: No default constructor found
     */
    @Autowired
    public StolenDeviceServiceImpl(StolenDeviceReportRepository stolenDeviceReportRepository) {
        this.stolenDeviceReportRepository = stolenDeviceReportRepository;
    }

    @Override
    public StolenDeviceReport reportStolen(StolenDeviceReport report) {
        return stolenDeviceReportRepository.save(report);
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return stolenDeviceReportRepository.findAll();
    }

    @Override
    public Optional<StolenDeviceReport> getReportById(Long id) {
        return stolenDeviceReportRepository.findById(id);
    }

    @Override
    public List<StolenDeviceReport> getReportsBySerial(String serial) {
        return stolenDeviceReportRepository.findByDeviceSerial(serial);
    }
}
