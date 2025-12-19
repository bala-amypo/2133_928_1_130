@Service
public class FraudRuleService {
    private final FraudRuleRepository repo;
    public FraudRuleService(FraudRuleRepository repo){ this.repo = repo; }
    public FraudRuleEntity save(FraudRuleEntity e){ return repo.save(e); }
    public List<FraudRuleEntity> getAll(){ return repo.findAll(); }
}
