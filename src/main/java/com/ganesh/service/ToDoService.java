package com.ganesh.service;

import java.util.List;
import java.util.Optional;

import com.ganesh.model.ToDo;


public interface ToDoService {
	
	public ToDo newTodo(ToDo todo);
	public List<ToDo> listOfToDo();
	public Optional<ToDo> getOneToDo(Integer todoId);
	public Optional<ToDo> updateToDo(Integer todoId, ToDo todo);
	public String deleteToDoById(int theId);

}
