package mk.ukim.finki.wp.project_v1.repository;

import mk.ukim.finki.wp.project_v1.model.Review;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository {

    List<Review> getAllReviews();

    Review save(Review review);

    Page<Review> getAllReviews(int page, int size);

    Optional<Review> findById(Long reviewId);

    void deleteById(Long reviewId);

    List<Review> findAllByaClass_id(String classId);
}
