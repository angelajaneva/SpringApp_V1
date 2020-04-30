package mk.ukim.finki.wp.project_v1.web.rest;

import mk.ukim.finki.wp.project_v1.model.Class;
import mk.ukim.finki.wp.project_v1.model.Review;
import mk.ukim.finki.wp.project_v1.service.ClassService;
import mk.ukim.finki.wp.project_v1.service.ReviewService;
import mk.ukim.finki.wp.project_v1.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class ReviewApi {

    private final ReviewService reviewService;
    private final ClassService classService;
    private final StudentService studentService;


    public ReviewApi(ReviewService reviewService, ClassService classService, StudentService studentService) {
        this.reviewService = reviewService;
        this.classService = classService;
        this.studentService = studentService;
    }

    @GetMapping("/reviews")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping(value = "/reviews/paged", params = "page")
    public Page<Review> getAllReviewsPaged(@RequestParam int page,
                                           @RequestParam(defaultValue = "3", required = false) int size) {
        return reviewService.getAllReviews(page, size);
    }

    @GetMapping(value = "/reviews", params = "term")
    public List<Review> getReviewsForClasses(@RequestParam String className) {

        Class aClass = classService.findByName(className);
        return reviewService.findAllByaClass_id(aClass.getId());
    }

    @PostMapping("/review/new")
    public Review createReview(@RequestParam String text, @RequestParam int rated,
                               @RequestParam String className) {

        Class aClass = classService.findByName(className);
        Review review = new Review();
        review.setText(text);
        review.setRated(rated);
        review.setCreatedOn(LocalDate.now());
        review.setAClass(aClass);
        //treba so security da se rese sega neka go vaka
//        review.setStudent(studentService.findById("S17001").get());
        System.out.println(aClass.getName());
        return reviewService.save(review);
    }
}
