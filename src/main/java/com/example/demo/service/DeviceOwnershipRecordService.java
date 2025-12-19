package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.*;
import com.example.demo.repository.*;

@Service
public class DeviceOwnershipRecordService {

    private final DeviceOwnershipRecordRepository repo;

    public DeviceOwnershipRecordService(DeviceOwnershipRecordRepository repo) {
        this.repo = repo;
    }

    public DeviceOwnershipRecordEntity save(DeviceOwnershipRecordEntity e) {
        return repo.save(e);
    }

    public List<DeviceOwnershipRecordEntity> getAll() {
        return repo.findAll();
    }
}
