package mk.ukim.finki.wp.project_v1.repository;

import mk.ukim.finki.wp.project_v1.model.Review;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ReviewRepository {

    Flux<Review> getAllReviews();

    Mono<Review> save(Review review);

    Flux<Review> getAllReviewsPaged(int page, int size);

    Mono<Review> findById(String reviewId);

    Mono<Void> deleteById(String reviewId);

    Flux<Review> findAllByaClass_name(String className);
}
