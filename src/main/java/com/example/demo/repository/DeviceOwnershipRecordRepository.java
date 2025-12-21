public interface DeviceOwnershipRecordRepository
        extends JpaRepository<DeviceOwnershipRecordEntity, Long> {
    boolean existsBySerialNumber(String serialNumber);
    Optional<DeviceOwnershipRecordEntity> findBySerialNumber(String serialNumber);
}
