package com.todoapp.Service.Impl;

import com.todoapp.Entities.NotesDtls;
import com.todoapp.Exceptions.ResourceNotFoundException;
import com.todoapp.Repositories.NotesRepo;
import com.todoapp.Service.NotesService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotesServiceImpl implements NotesService {

    NotesRepo notesRepo;


    @Override
    public NotesDtls getNoteById(int id) {
        NotesDtls note = notesRepo.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Note not found with the given id"+id));
        return note;
    }

    @Override
    public List<NotesDtls> getAllNotes() {
        List<NotesDtls> allNotes = notesRepo.findAll();
        allNotes.stream().collect(Collectors.toList());
        return allNotes;
    }

    @Override
    public NotesDtls createNote(NotesDtls note) {
        notesRepo.save(note);
        return note;
    }

    @Override
    public NotesDtls updateNote(int id, NotesDtls note) {
        NotesDtls currentNote = notesRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("No note present with the given id to update"));

        currentNote.setTitle(note.getTitle());
        currentNote.setDescription(note.getDescription());
        return currentNote;
    }

    @Override
    public void deleteNotes(int id) {
        NotesDtls toBeDeleted = notesRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("No note present to be deleted with given id"));
        notesRepo.deleteById(toBeDeleted.getId());
        return;
    }
}
