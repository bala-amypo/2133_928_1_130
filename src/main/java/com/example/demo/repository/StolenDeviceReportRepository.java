public interface StolenDeviceReportRepository
        extends JpaRepository<StolenDeviceReport, Long> {

    StolenDeviceReport findBySerialNumber(String serialNumber);
}
