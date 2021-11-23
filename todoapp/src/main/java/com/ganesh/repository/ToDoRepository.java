package com.ganesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.model.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

}
