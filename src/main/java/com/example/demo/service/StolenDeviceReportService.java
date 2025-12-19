@Service
public class StolenDeviceService {

    private final StolenDeviceReportRepository stolenRepo;
    private final DeviceOwnershipRecordRepository ownershipRepo;

    public StolenDeviceService(StolenDeviceReportRepository stolenRepo,
                               DeviceOwnershipRecordRepository ownershipRepo) {
        this.stolenRepo = stolenRepo;
        this.ownershipRepo = ownershipRepo;
    }

    public boolean isStolen(String serial) {
        return stolenRepo.findBySerialNumber(serial) != null;
    }
}
