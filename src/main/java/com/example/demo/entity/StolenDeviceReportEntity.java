package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.dto.StolenDeviceReportDTO;

@Service
public class StolenDeviceReportService {

    public List<StolenDeviceReportDTO> findAll() {
        return List.of(); // dummy data for now
    }
}
