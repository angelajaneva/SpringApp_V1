package mk.ukim.finki.wp.project_v1.repository.impl;

import mk.ukim.finki.wp.project_v1.model.User;
import mk.ukim.finki.wp.project_v1.repository.UserRepository;
import mk.ukim.finki.wp.project_v1.repository.mongo.MongoUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final MongoUserRepository mongoUserRepository;

    @Override
    public User save(User user) {
        return mongoUserRepository.save(user);
    }

    @Override
    public boolean existsByUsername(String username) {
        return mongoUserRepository.existsByUsername(username);
    }

    public UserRepositoryImpl(MongoUserRepository mongoUserRepository) {
        this.mongoUserRepository = mongoUserRepository;
    }

    @Override
    public Optional<User> findById(String id) {
        return mongoUserRepository.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return mongoUserRepository.findByUsername(username);
    }
}
