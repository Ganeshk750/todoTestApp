package com.ganesh.service;

import java.util.Optional;

import com.ganesh.model.ToDo;


public interface ToDoService {
	
	public ToDo newTodo(ToDo todo);
	public java.util.List<ToDo> listOfToDo();
	public Optional<ToDo> getOneToDo(Integer todoId);
	public Optional<ToDo> updateToDo(Integer todoId, ToDo todo);
	public Integer deleteToDoById(int theId);

}
