package mk.ukim.finki.wp.project_v1.web.rest;

import mk.ukim.finki.wp.project_v1.model.Class;
import mk.ukim.finki.wp.project_v1.model.Student;
import mk.ukim.finki.wp.project_v1.service.StudentService;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class StudentApi {

    private final StudentService studentService;

    public StudentApi(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public Flux<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    //treba nesto sign in forma za da se zeme imeto
    @GetMapping("/student/{studentId}")
    public Mono<String> getName(@PathVariable String studentId) {
        Mono<Student> studentMono = studentService.findById(studentId);
        return studentMono.map(student -> student.getFirstName() + " " + student.getLastName());
    }
//    @GetMapping("/classes/{studentId}")
//    public List<Class> getClassesForStudent(@PathVariable String studentId){
//        return studentService.findClassesForStudent(studentId);
//    }

}
