package mk.ukim.finki.wp.project_v1.repository;

import mk.ukim.finki.wp.project_v1.model.Note;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface NotesRepository {

    Flux<Note> getAllNotes();

    Mono<Note> save(Note note);

    Mono<Note> findById(String noteId);

    Mono<Void> deleteById(String noteId);

    Flux<Note> getNotesByAClass(String AClass);

}
