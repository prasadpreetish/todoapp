package com.todoapp.Service;

import com.todoapp.Entities.NotesDtls;

import java.util.List;

public interface NotesService {

    NotesDtls getNoteById(int id);
    List<NotesDtls> getAllNotes();

    NotesDtls createNote(NotesDtls note);

    NotesDtls updateNote(int id,NotesDtls note);

    void deleteNotes(int id);
}
