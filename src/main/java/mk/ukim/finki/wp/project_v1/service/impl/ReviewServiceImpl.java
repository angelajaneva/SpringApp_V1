package mk.ukim.finki.wp.project_v1.service.impl;

import mk.ukim.finki.wp.project_v1.model.Review;
import mk.ukim.finki.wp.project_v1.repository.ReviewRepository;
import mk.ukim.finki.wp.project_v1.service.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Flux<Review> getAllReviews() {
        return reviewRepository.getAllReviews();
    }

    @Override
    public Mono<Review> save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Flux<Review> getAllReviewsPaged(int page, int size) {
        return reviewRepository.getAllReviewsPaged(page, size);
    }

    @Override
    public Mono<Review> findById(String reviewId) {
        return reviewRepository.findById(reviewId);
    }

    @Override
    public Mono<Void> deleteById(String reviewId) {
        return reviewRepository.deleteById(reviewId);
    }

    @Override
    public Flux<Review> findAllByaClass_id(String classId) {
        return reviewRepository.findAllByaClass_id(classId);
    }
}
