package mk.ukim.finki.wp.project_v1.repository.mongo;

import mk.ukim.finki.wp.project_v1.model.Class;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface MongoClassRepository extends MongoRepository<Class, String> {

    List<Class> findClassesByStudents_username(String username);

    Class findByName(String className);
}
