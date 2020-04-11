package mk.ukim.finki.wp.project_v1.service.impl;

import mk.ukim.finki.wp.project_v1.model.Review;
import mk.ukim.finki.wp.project_v1.repository.ReviewRepository;
import mk.ukim.finki.wp.project_v1.service.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.getAllReviews();
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Page<Review> getAllReviews(int page, int size) {
        return reviewRepository.getAllReviews(page, size);
    }

    @Override
    public Optional<Review> findById(long reviewId) {
        return reviewRepository.findById(reviewId);
    }

    @Override
    public void deleteById(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    @Override
    public List<Review> findAllByaClass_id(String classId) {
        return reviewRepository.findAllByaClass_id(classId);
    }
}
