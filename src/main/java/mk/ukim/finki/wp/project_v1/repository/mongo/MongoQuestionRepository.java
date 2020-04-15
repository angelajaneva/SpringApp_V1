package mk.ukim.finki.wp.project_v1.repository.mongo;

import mk.ukim.finki.wp.project_v1.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoQuestionRepository extends MongoRepository<Question, String> {

    List<Question> getQuestionsByaClass_Id(String classId);

}