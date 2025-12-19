@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    public UserController(UserService service){ this.service = service; }
    @PostMapping public UserEntity save(@RequestBody UserEntity e){ return service.save(e); }
    @GetMapping public List<UserEntity> getAll(){ return service.getAll(); }
}
