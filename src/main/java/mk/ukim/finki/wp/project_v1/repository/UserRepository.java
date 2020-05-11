package mk.ukim.finki.wp.project_v1.repository;

import mk.ukim.finki.wp.project_v1.model.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(String id);

    User findByUsername(String  username);

    User save (User user);

    boolean existsByUsername(String username);

}
