package mk.ukim.finki.wp.project_v1.service.impl;

import mk.ukim.finki.wp.project_v1.model.Review;
import mk.ukim.finki.wp.project_v1.model.Student;
import mk.ukim.finki.wp.project_v1.repository.ClassRepository;
import mk.ukim.finki.wp.project_v1.repository.ReviewRepository;
import mk.ukim.finki.wp.project_v1.repository.UserRepository;
import mk.ukim.finki.wp.project_v1.service.ReviewService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ClassRepository classRepository;
    private final UserRepository userRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ClassRepository classRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.classRepository = classRepository;
        this.userRepository = userRepository;
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
    public Flux<Review> findAllByaClass_name(String className) {
        return reviewRepository.findAllByaClass_name(className);
    }

    @Override
    public Mono<Review> createReview(String text, int rated, String className, String username) {

        Review review = new Review();

        Student student = userRepository.findByUsername(username).getStudent();

        return classRepository.findByName(className).flatMap(aClass -> {
            review.setAClass(aClass);
            review.setStudent(student);
            review.setText(text);
            review.setRated(rated);
            review.setCreatedOn(LocalDate.now());
            return reviewRepository.save(review);
        });
    }
}
