@RestController
@RequestMapping("/stolen-device")
public class StolenDeviceReportController {
    private final StolenDeviceReportService service;
    public StolenDeviceReportController(StolenDeviceReportService service){ this.service = service; }
    @PostMapping public StolenDeviceReportEntity save(@RequestBody StolenDeviceReportEntity e){ return service.save(e); }
    @GetMapping public List<StolenDeviceReportEntity> getAll(){ return service.getAll(); }
}
