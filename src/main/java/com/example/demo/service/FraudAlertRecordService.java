@Service
public class FraudAlertService {

    private final FraudAlertRecordRepository repository;

    public FraudAlertService(FraudAlertRecordRepository repository) {
        this.repository = repository;
    }

    public List<FraudAlertRecord> getAllAlerts() {
        return repository.findAll();
    }
}
