package mk.ukim.finki.wp.project_v1.repository.mongo;

import mk.ukim.finki.wp.project_v1.model.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface MongoReviewRepository extends ReactiveMongoRepository<Review, String>, ReactiveCrudRepository<Review, String> {

    Flux<Review> findAllByaClass_id(String classId);

    @Query("{ id: { $exists: true }}")
    Flux<Review> retrieveAllQuotesPaged(final Pageable page);
}


