package mk.ukim.finki.wp.project_v1.web.rest;

import mk.ukim.finki.wp.project_v1.model.Class;
import mk.ukim.finki.wp.project_v1.model.Review;
import mk.ukim.finki.wp.project_v1.service.ClassService;
import mk.ukim.finki.wp.project_v1.service.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class ReviewApi {

    private final ReviewService reviewService;
    private final ClassService classService;

    public ReviewApi(ReviewService reviewService, ClassService classService) {
        this.reviewService = reviewService;
        this.classService = classService;
    }

    @GetMapping("/reviews")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/reviews/paged")
    public Page<Review> getAllReviewsPaged(@RequestParam(defaultValue = "0", required = false) int page,
                                           @RequestParam(defaultValue = "5", required = false) int size) {
        return reviewService.getAllReviews(page, size);
    }

    @GetMapping("reviews/{classId}")
    public List<Review> getReviewsForClasses(@PathVariable String classId) {
        return reviewService.findAllByaClass_id(classId);
    }

    @PostMapping("/review/new")
    public Review createReview(@RequestParam String text, @RequestParam int rated,
                               @RequestParam String classId) {

        Class aClass = classService.findById(classId).orElseThrow(RuntimeException::new);
        Review review = new Review();
        review.setText(text);
        review.setRated(rated);
        review.setCreatedOn(LocalDate.now());
        review.setAClass(aClass);

        return reviewService.save(review);
    }


}
