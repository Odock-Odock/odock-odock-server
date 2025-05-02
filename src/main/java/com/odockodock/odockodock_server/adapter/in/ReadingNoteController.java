package com.odockodock.odockodock_server.adapter.in;

import com.odockodock.odockodock_server.adapter.out.UserRepository;
import com.odockodock.odockodock_server.application.port.in.ReadingNoteUserCase;
import com.odockodock.odockodock_server.domain.ReadingNote;
import com.odockodock.odockodock_server.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestControllerAdvice // = @ControllerAdvice + @ResponseBody
@RequestMapping("/reading-note")
public class ReadingNoteController {

    @Autowired
    ReadingNoteUserCase readingNoteUserCase;

    @Autowired
    UserRepository userRepository;  // 누락되어 있던 부분

    // JWT
    Long userId = 1L;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ReadingNote readingNote){
        readingNoteUserCase.create(readingNote);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list-search")
    public List<ReadingNote> list(){
        return readingNoteUserCase.list(userId);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody ReadingNote readingNote){
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("사용자 없음"));
        readingNote.setUser(user);
        readingNoteUserCase.update(readingNote);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<?> delete(@PathVariable("noteId") Long noteId) {
        readingNoteUserCase.delete(noteId);
        return ResponseEntity.noContent().build();
    }

}
