@RestController
@RequestMapping("/api/stolen")
public class StolenDeviceReportController {

    private final StolenDeviceService stolenDeviceService;

    public StolenDeviceReportController(StolenDeviceService stolenDeviceService) {
        this.stolenDeviceService = stolenDeviceService;
    }

    @GetMapping("/{serialNumber}")
    public boolean isStolen(
            @PathVariable String serialNumber) {

        return stolenDeviceService.isStolen(serialNumber);
    }
}
