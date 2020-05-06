package mk.ukim.finki.wp.project_v1.repository.impl;

import mk.ukim.finki.wp.project_v1.model.Review;
import mk.ukim.finki.wp.project_v1.repository.ReviewRepository;
import mk.ukim.finki.wp.project_v1.repository.mongo.MongoReviewRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public class ReviewRepositoryImpl implements ReviewRepository {

    private final MongoReviewRepository mongoReviewRepository;

    public ReviewRepositoryImpl(MongoReviewRepository jpaReviewRepository) {
        this.mongoReviewRepository = jpaReviewRepository;
    }

    @Override
    public Flux<Review> getAllReviews() {
        return mongoReviewRepository.findAll();
    }

    @Override
    public Mono<Review> save(Review review) {
        return mongoReviewRepository.save(review);
    }

    @Override
    public Flux<Review> getAllReviewsPaged(int page, int size) {
        return mongoReviewRepository.retrieveAllQuotesPaged(PageRequest.of(page, size));
    }

    @Override
    public Mono<Review> findById(String reviewId) {
        return mongoReviewRepository.findById(reviewId);
    }

    @Override
    public Mono<Void> deleteById(String reviewId) {
        return mongoReviewRepository.deleteById(reviewId);
    }

    @Override
    public Flux<Review> findAllByaClass_id(String classId) {
        return mongoReviewRepository.findAllByaClass_id(classId);
    }
}
