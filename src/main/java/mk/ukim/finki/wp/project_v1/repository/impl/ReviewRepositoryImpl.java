package mk.ukim.finki.wp.project_v1.repository.impl;

import mk.ukim.finki.wp.project_v1.model.Review;
import mk.ukim.finki.wp.project_v1.repository.ReviewRepository;
import mk.ukim.finki.wp.project_v1.repository.mongo.MongoReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {

    private final MongoReviewRepository mongoReviewRepository;

    public ReviewRepositoryImpl(MongoReviewRepository jpaReviewRepository) {
        this.mongoReviewRepository = jpaReviewRepository;
    }

    @Override
    public List<Review> getAllReviews() {
        return mongoReviewRepository.findAll();
    }

    @Override
    public Review save(Review review) {
        return mongoReviewRepository.save(review);
    }

    @Override
    public Page<Review> getAllReviews(int page, int size) {
        return mongoReviewRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<Review> findById(Long reviewId) {
        return mongoReviewRepository.findById(reviewId);
    }

    @Override
    public void deleteById(Long reviewId) {
        mongoReviewRepository.deleteById(reviewId);
    }

    @Override
    public List<Review> findAllByaClass_id(String classId) {
        return mongoReviewRepository.findAllByaClass_id(classId);
    }
}
