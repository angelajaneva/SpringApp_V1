package mk.ukim.finki.wp.project_v1.repository.mongo;

import mk.ukim.finki.wp.project_v1.model.Question;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;


public interface MongoQuestionRepository extends ReactiveMongoRepository<Question, String> {

    Flux<Question> getQuestionsByaClass_Id(String classId);

}
