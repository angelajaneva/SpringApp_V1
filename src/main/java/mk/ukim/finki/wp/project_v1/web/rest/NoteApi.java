package mk.ukim.finki.wp.project_v1.web.rest;


import mk.ukim.finki.wp.project_v1.model.Note;
import mk.ukim.finki.wp.project_v1.service.NotesService;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class NoteApi {

    private final NotesService notesService;

    public NoteApi(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("/notes")
    public Flux<Note> getAllNotes() {
        return notesService.getAllNotes();
    }

    @GetMapping("/note/{noteId}")
    public Mono<Note> getNoteById(@PathVariable String noteId) {
        return notesService.findById(noteId);
    }

    @GetMapping("/notes/{classId}")
    public Flux<Note> getNotesForClass(@PathVariable String classId) {
        return notesService.getNotesByAClass(classId);
    }

    @PostMapping("/note")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Note> createNote(@RequestParam String title, @RequestParam String description,
                           @RequestParam String classId) {
        return notesService.createNote(title, description, classId);
    }

    @PatchMapping("/note/edit")
    public Mono<Note> editNote(@RequestParam String noteId, @RequestParam String title,
                               @RequestParam String description) {

        return notesService.updateNote(noteId, title, description);
    }

    @DeleteMapping("/{noteId}")
    public Mono<Void> deleteNote(@PathVariable String noteId) {
        return notesService.deleteById(noteId);
    }

    @GetMapping(value = "/notes", params = "term")
    public Flux<Note> searchNotes(@RequestParam String term) {
        return notesService.searchNotes(term);
    }
}
