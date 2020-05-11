package mk.ukim.finki.wp.project_v1.repository.mongo;

import mk.ukim.finki.wp.project_v1.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoUserRepository extends MongoRepository<User, String> {

    User findByUsername(String  username);

    boolean existsByUsername(String username);
}
