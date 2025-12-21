public interface StolenDeviceReportRepository
        extends JpaRepository<StolenDeviceReportEntity, Long> {
    boolean existsBySerialNumber(String serialNumber);
    Optional<StolenDeviceReportEntity> findBySerialNumber(String serialNumber);
}
