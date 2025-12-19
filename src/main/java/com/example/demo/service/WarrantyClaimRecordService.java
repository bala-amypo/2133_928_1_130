@Service
public class WarrantyClaimRecordService {
    private final WarrantyClaimRecordRepository repo;
    public WarrantyClaimRecordService(WarrantyClaimRecordRepository repo){ this.repo = repo; }
    public WarrantyClaimRecordEntity save(WarrantyClaimRecordEntity e){ return repo.save(e); }
    public List<WarrantyClaimRecordEntity> getAll(){ return repo.findAll(); }
}
