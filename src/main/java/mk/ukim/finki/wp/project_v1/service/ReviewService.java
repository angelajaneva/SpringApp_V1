package mk.ukim.finki.wp.project_v1.service;


import mk.ukim.finki.wp.project_v1.model.Review;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ReviewService  {

    Flux<Review> getAllReviews();

    Mono<Review> save(Review review);

    Flux<Review> getAllReviewsPaged(int page, int size);

    Mono<Review> findById(String reviewId);

    Mono<Void> deleteById(String reviewId);

    Flux<Review> findAllByaClass_name(String className);

    Mono<Review> createReview(String text, int rated, String className, String username);
}
