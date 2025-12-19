@Service
public class DeviceOwnershipService {

    private final DeviceOwnershipRecordRepository repository;

    public DeviceOwnershipService(DeviceOwnershipRecordRepository repository) {
        this.repository = repository;
    }

    public DeviceOwnershipRecord getBySerial(String serial) {
        DeviceOwnershipRecord record = repository.findBySerialNumber(serial);
        if (record == null) {
            throw new IllegalArgumentException("Device not found");
        }
        return record;
    }
}
