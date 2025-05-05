package com.odockodock.odockodock_server.application.port.in;

import com.odockodock.odockodock_server.domain.ReadingNote;
import com.odockodock.odockodock_server.domain.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ReadingNoteUserCase {
    void create(ReadingNote readingNote);
    List<ReadingNote> list(Long userId);
    void update(ReadingNote readingNote);
    void delete(Long noteId);
    List<ReadingNote> draft(User user);
}
