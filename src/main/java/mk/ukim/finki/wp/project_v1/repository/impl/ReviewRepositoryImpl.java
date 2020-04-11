package mk.ukim.finki.wp.project_v1.repository.impl;

import mk.ukim.finki.wp.project_v1.model.Review;
import mk.ukim.finki.wp.project_v1.repository.ReviewRepository;
import mk.ukim.finki.wp.project_v1.repository.jpa.JpaReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {

    private final JpaReviewRepository jpaReviewRepository;

    public ReviewRepositoryImpl(JpaReviewRepository jpaReviewRepository) {
        this.jpaReviewRepository = jpaReviewRepository;
    }

    @Override
    public List<Review> getAllReviews() {
        return jpaReviewRepository.findAll();
    }

    @Override
    public Review save(Review review) {
        return jpaReviewRepository.save(review);
    }

    @Override
    public Page<Review> getAllReviews(int page, int size) {
        return jpaReviewRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<Review> findById(Long reviewId) {
        return jpaReviewRepository.findById(reviewId);
    }

    @Override
    public void deleteById(Long reviewId) {
        jpaReviewRepository.deleteById(reviewId);
    }

    @Override
    public List<Review> findAllByaClass_id(String classId) {
        return jpaReviewRepository.findAllByaClass_id(classId);
    }
}
