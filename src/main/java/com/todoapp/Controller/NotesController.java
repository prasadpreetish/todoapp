package com.todoapp.Controller;

import com.todoapp.Entities.NotesDtls;
import com.todoapp.Service.NotesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class NotesController {

    private NotesService notesService;

    @GetMapping("/all")
    public ResponseEntity<List<NotesDtls>> getAllNotes(){
        List<NotesDtls> allNotes = notesService.getAllNotes();
        return ResponseEntity.ok(allNotes);
    }

    @PostMapping("/create")
    public ResponseEntity<NotesDtls> createNote(NotesDtls note){
        NotesDtls newNote = notesService.createNote(note);
        return ResponseEntity.ok(note);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<NotesDtls> editNote(@PathVariable int id,NotesDtls updatedDataNote){
        NotesDtls newNote = notesService.updateNote(id, updatedDataNote);
        return ResponseEntity.ok(newNote);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable("id") int id){
        notesService.deleteNotes(id);
        return ResponseEntity.ok("Note deleted successfully.");
    }
}
