package mk.ukim.finki.wp.project_v1.repository.mongo;

import mk.ukim.finki.wp.project_v1.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoReviewRepository extends MongoRepository<Review, Long> {

    List<Review> findAllByaClass_id(String classId);
}
