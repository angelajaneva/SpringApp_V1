package mk.ukim.finki.wp.project_v1.service;

import mk.ukim.finki.wp.project_v1.model.Note;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface NotesService {

    Flux<Note> getAllNotes();

    Mono<Note> save(Note note);

    Mono<Note> findById(String noteId);

    Mono<Void> deleteById(String noteId);

    Flux<Note> getNotesByAClass(String AClass);

    Mono<Note> updateNote(String id, String title, String description);

    Flux<Note> searchNotes (String term);

    Mono<Note> createNote( String title,  String description, String classId);
}
