package com.ganesh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public Optional<ToDo> getOneToDo(Integer todoId) {
	    var todo = this.repository.findById(todoId);
		return todo;
	}

	@Override
	public Optional<ToDo> updateToDo(Integer todoId, ToDo todo) {
		return this.repository.findById(todoId).map(oldTodo -> this.repository.save(todo));
	}

	@Override
	public String deleteToDoById(int theId) {
		repository.deleteById(theId);
		return "Delete Sucessfully";
	}
	
}
