package mk.ukim.finki.wp.project_v1.web.rest;


import mk.ukim.finki.wp.project_v1.model.Class;
import mk.ukim.finki.wp.project_v1.model.Note;
import mk.ukim.finki.wp.project_v1.model.Student;
import mk.ukim.finki.wp.project_v1.service.ClassService;
import mk.ukim.finki.wp.project_v1.service.NotesService;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class NoteApi {

    private final NotesService notesService;
    private final ClassService classService;

    public NoteApi(NotesService notesService, ClassService classService) {
        this.notesService = notesService;
        this.classService = classService;
    }

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return notesService.getAllNotes();
    }

    @GetMapping("/note/{noteId}")
    public Note getNoteById(@PathVariable String noteId) {
        return notesService.findById(noteId).orElseThrow(RuntimeException::new);
    }

    @GetMapping("/notes/{classId}")
    public List<Note> getNotesForClass(@PathVariable String classId) {
        return notesService.getNotesByAClass(classId);
    }

    @PostMapping("/note")
    @ResponseStatus(HttpStatus.CREATED)
    public Note createNote(@RequestParam String title, @RequestParam String description,
                           @RequestParam String classId) {
        Note note = new Note();
        Class aClass = classService.findById(classId).orElseThrow(RuntimeException::new);
        note.setTitle(title);
        note.setDescription(description);
        note.setAClass(aClass);

        return notesService.save(note);

    }

    @PatchMapping("/{noteId}")
    public Note editNote(@PathVariable String noteId, @RequestParam String title,
                         @RequestParam String description) {
       return notesService.updateNote(noteId, title, description);
    }

    @DeleteMapping("/{noteId}")
    public void deleteNote(@PathVariable String noteId) {
        notesService.deleteById(noteId);
    }
}
