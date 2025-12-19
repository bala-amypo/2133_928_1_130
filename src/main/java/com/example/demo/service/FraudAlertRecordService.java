@Service
public class FraudAlertRecordService {
    private final FraudAlertRecordRepository repo;
    public FraudAlertRecordService(FraudAlertRecordRepository repo) { this.repo = repo; }
    public FraudAlertRecordEntity save(FraudAlertRecordEntity e){ return repo.save(e); }
    public List<FraudAlertRecordEntity> getAll(){ return repo.findAll(); }
}
