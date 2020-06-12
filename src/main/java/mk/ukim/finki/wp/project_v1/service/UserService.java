package mk.ukim.finki.wp.project_v1.service;

import mk.ukim.finki.wp.project_v1.model.User;

import java.util.Optional;

public interface UserService {

    User save (User user);

    Optional<User> findById(String id);

    String signin(String username, String password);

    String signup(User user);

    User findByUsername(String username);

    User createNewUser(String name, String surname, String username, String password);
}
