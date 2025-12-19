@Service
public class UserService {
    private final UserRepository repo;
    public UserService(UserRepository repo){ this.repo = repo; }
    public UserEntity save(UserEntity e){ return repo.save(e); }
    public List<UserEntity> getAll(){ return repo.findAll(); }
}
