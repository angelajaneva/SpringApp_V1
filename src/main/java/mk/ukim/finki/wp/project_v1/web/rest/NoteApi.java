package mk.ukim.finki.wp.project_v1.web.rest;


import mk.ukim.finki.wp.project_v1.data.DataHolder;
import mk.ukim.finki.wp.project_v1.model.Class;
import mk.ukim.finki.wp.project_v1.model.Note;
import mk.ukim.finki.wp.project_v1.model.Student;
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

    public NoteApi(NotesService notesService) {
        this.notesService = notesService;
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
                           @PathVariable String classId, Student student) {

        DataHolder.noteCounter ++;
        String noteId = "n0" + DataHolder.noteCounter;
        return notesService.save(new Note());

    }

    @PatchMapping("/{noteId}")
    public void editNote(@PathVariable String noteId, @RequestParam String title,
                         @RequestParam String description) {
        notesService.updateNote(noteId, title, description);
    }

    @DeleteMapping("/{noteId}")
    public void deleteNote(@PathVariable String noteId) {
        notesService.deleteById(noteId);
    }
}
