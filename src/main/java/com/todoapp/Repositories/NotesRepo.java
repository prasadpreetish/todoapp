package com.todoapp.Repositories;

import com.todoapp.Entities.NotesDtls;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepo extends JpaRepository<NotesDtls, Integer> {
}
