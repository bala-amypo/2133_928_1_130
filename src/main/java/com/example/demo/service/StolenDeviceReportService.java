@Service
public class StolenDeviceReportService {
    private final StolenDeviceReportRepository repo;
    public StolenDeviceReportService(StolenDeviceReportRepository repo){ this.repo = repo; }
    public StolenDeviceReportEntity save(StolenDeviceReportEntity e){ return repo.save(e); }
    public List<StolenDeviceReportEntity> getAll(){ return repo.findAll(); }
}
