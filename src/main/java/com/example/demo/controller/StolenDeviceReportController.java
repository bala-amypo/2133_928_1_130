@RestController
@RequestMapping("/api/stolen")
public class StolenDeviceController {

    private final StolenDeviceService stolenDeviceService;

    public StolenDeviceController(StolenDeviceService stolenDeviceService) {
        this.stolenDeviceService = stolenDeviceService;
    }

    @GetMapping("/{serialNumber}")
    public boolean isStolen(
            @PathVariable String serialNumber) {

        return stolenDeviceService.isStolen(serialNumber);
    }
}
