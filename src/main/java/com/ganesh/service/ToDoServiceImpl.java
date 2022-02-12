package com.ganesh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ganesh.model.ToDo;
import com.ganesh.repository.ToDoRepository;

import lombok.RequiredArgsConstructor;
import lombok.var;

@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {
	
	
	private final ToDoRepository repository;
	

	@Override
	public ToDo newTodo(ToDo todo) {
		return this.repository.save(todo);
	}

	@Override
	public List<ToDo> listOfToDo() {
		return this.repository.findAll();		
	}

	@Override
	public ToDo getOneToDo(Integer todoId) {
	    Optional<ToDo> todo = this.repository.findById(todoId);
		return todo.get();
	}

	@Override
	public Optional<ToDo> updateToDo(Integer todoId, ToDo todo) {
		return this.repository.findById(todoId).map(oldTodo -> this.repository.save(todo));
	}

	@Override
	public String deleteToDoById(int todoId) {
		repository.deleteById(todoId);
		return "Delete Sucessfully";
	}
	
}
