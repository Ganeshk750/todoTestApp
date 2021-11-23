package com.ganesh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.model.ToDo;
import com.ganesh.service.ToDoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("todos")
public class ToDoController {
	
	private final ToDoService service;
	
	@PostMapping("/add")
	public ToDo addToDo(@RequestBody ToDo todo) {
		return this.service.newTodo(todo);
	}
	
	@GetMapping("/gets")
	public List<ToDo> getListOfToDo(){
		return this.service.listOfToDo();
	}
	
	@GetMapping("/{todoId}")
	public Optional<ToDo> getOneToDo(@PathVariable("todoId") Integer totoId) {
		return this.service.getOneToDo(totoId);
	}
	
	@PutMapping("/{todoId}")
	public Optional<ToDo> getOneToDo(@PathVariable("todoId") Integer totoId, @RequestBody ToDo toDo) {
		return this.service.updateToDo(totoId, toDo);
	}

}
