package mk.ukim.finki.wp.project_v1.web.rest;

import mk.ukim.finki.wp.project_v1.model.Class;
import mk.ukim.finki.wp.project_v1.service.ClassService;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/class", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class ClassApi {

    private final ClassService classService;

    public ClassApi(ClassService classService) {
        this.classService = classService;
    }


    @GetMapping("/{classId}")
    public Mono<String> getClassName(@PathVariable String classId) {
        Mono<Class> classMono = classService.findById(classId);
        return classMono.map(Class::getName);
    }

    @GetMapping("/student/{username}")
    public Flux<Class> findClassesByStudentUsername (@PathVariable String username){
        return classService.findClassesByStudents_username(username);
    }
}
