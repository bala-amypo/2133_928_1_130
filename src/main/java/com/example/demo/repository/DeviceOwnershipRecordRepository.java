public interface DeviceOwnershipRecordRepository
        extends JpaRepository<DeviceOwnershipRecord, Long> {

    DeviceOwnershipRecord existsBySerialNumber(String serialNumber);
    DeviceOwnershipRecord findBySerialNumber(String serialNumber);
}
