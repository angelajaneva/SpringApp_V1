package mk.ukim.finki.wp.project_v1.web.rest;

import mk.ukim.finki.wp.project_v1.model.Class;
import mk.ukim.finki.wp.project_v1.service.ClassService;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/class", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class ClassApi {

    private final ClassService classService;

    public ClassApi(ClassService classService) {
        this.classService = classService;
    }


    @GetMapping("/{classId}")
    public String getClassName(@PathVariable String classId) throws Exception {
        Class AClass = classService.findById(classId).orElseThrow(Exception::new);
        return AClass.getName();
    }

    @GetMapping("/student/{studentId}")
    public List<Class> findClassesByStudentsId (@PathVariable String studentId){
        return classService.findClassesByStudents_Id(studentId);
    }
}
