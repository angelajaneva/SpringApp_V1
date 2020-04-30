package mk.ukim.finki.wp.project_v1.repository.mongo;

import mk.ukim.finki.wp.project_v1.model.Comment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;



public interface MongoCommentRepository extends ReactiveMongoRepository<Comment, String> {

    Flux<Comment> getCommentsByQuestion_Id(String questionId);
}
