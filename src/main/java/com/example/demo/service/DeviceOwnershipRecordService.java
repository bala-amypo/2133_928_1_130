package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.entity.DeviceOwnershipRecordEntity;
import java.util.List;

@Service
public class DeviceOwnershipRecordService {

    private final DeviceOwnershipRecordRepository repo;

    public DeviceOwnershipRecordService(DeviceOwnershipRecordRepository repo) {
        this.repo = repo;
    }

    public List<DeviceOwnershipRecordEntity> findAll() {
        return repo.findAll();
    }
}
