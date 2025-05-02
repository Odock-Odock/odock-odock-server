package com.odockodock.odockodock_server.application.service;

import com.odockodock.odockodock_server.adapter.out.UserRepository;
import com.odockodock.odockodock_server.application.port.in.ReadingNoteUserCase;
import com.odockodock.odockodock_server.application.port.out.ReadingNoteRespositoryPort;
import com.odockodock.odockodock_server.domain.ReadingNote;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadingNoteService implements ReadingNoteUserCase {


    private final ReadingNoteRespositoryPort readingNoteRespositoryPort;

    private final UserRepository userRepository;

    @Override
    public void create(ReadingNote readingNote) {
        readingNoteRespositoryPort.save(readingNote);
    }

    @Override
    public List<ReadingNote> list(Long userId) {
        return readingNoteRespositoryPort.findByUserId(userId);
    }

    @Transactional
    public void update(ReadingNote readingNote) {

            ReadingNote existing = readingNoteRespositoryPort.findByNoteId(readingNote.getNoteId())
                    .orElseThrow(() -> new RuntimeException("not found"));

        readingNote.setCreatedAt(existing.getCreatedAt()); // ⭐ 반드시 기존 값 복원
        readingNoteRespositoryPort.update(readingNote);
    }

    @Transactional
    public void delete(Long noteId) {
        ReadingNote note = readingNoteRespositoryPort.findByNoteId(noteId)
                .orElseThrow(() -> new RuntimeException("글을 찾을 수 없습니다."));

        readingNoteRespositoryPort.delete(noteId);
    }



}
