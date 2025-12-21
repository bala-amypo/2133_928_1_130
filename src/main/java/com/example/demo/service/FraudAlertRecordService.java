package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.entity.FraudAlertRecordEntity;
import java.util.List;

@Service
public class FraudAlertRecordService {

    private final FraudAlertRecordRepository repo;

    public FraudAlertRecordService(FraudAlertRecordRepository repo) {
        this.repo = repo;
    }

    public List<FraudAlertRecordEntity> findAll() {
        return repo.findAll();
    }
}
