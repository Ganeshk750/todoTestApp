package com.ganesh.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.dto.DtoToDo;
import com.ganesh.model.ToDo;
import com.ganesh.service.ToDoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;


@Api(value="CRUD TODO REST APIs")
@RestController
@RequiredArgsConstructor
@RequestMapping("todos")
@CrossOrigin(origins = "*")
public class ToDoController {
	
	private final ToDoService service;
		
	private final ModelMapper modelMapper;
	
	@ApiOperation(value="ADD TODO REST APIs")
	@PostMapping("/add")
	public ResponseEntity<DtoToDo> addToDo(@RequestBody DtoToDo todo) {
		ToDo Request = modelMapper.map(todo,ToDo.class);
		ToDo output = this.service.newTodo(Request);
		DtoToDo Response = modelMapper.map(output,DtoToDo.class);
		return new ResponseEntity<DtoToDo>(Response, HttpStatus.CREATED);
	}
	
	@ApiOperation(value="Get All TODO REST APIs")
	@GetMapping("/gets")
	public List<DtoToDo> getListOfToDo(){
		return this.service.listOfToDo()
				.stream()
				.map(todo -> modelMapper.map(todo, DtoToDo.class))
				.collect(Collectors.toList());
	}
	
	@ApiOperation(value="Get TODO Besed On Ids TODO APIs")
	@GetMapping("/{todoId}")
	public ResponseEntity<DtoToDo> getOneToDo(@PathVariable("todoId") Integer totoId) {
		ToDo todo = this.service.getOneToDo(totoId);
		DtoToDo Response = modelMapper.map(todo, DtoToDo.class);
		return ResponseEntity.ok().body(Response);
	}
	
	@ApiOperation(value="Update TODO Besed On Ids TODO APIs")
	@PutMapping("/{todoId}")
	public ResponseEntity<DtoToDo> updateToDo(@PathVariable("todoId") Integer totoId, @RequestBody DtoToDo dtoToDo) {
         ToDo request = modelMapper.map(dtoToDo, ToDo.class);		
		 Optional<ToDo> result = this.service.updateToDo(totoId, request);
		 DtoToDo response = modelMapper.map(result, DtoToDo.class);
		return ResponseEntity.ok().body(response);
	}
	
	@ApiOperation(value="Delete TODO Besed On Ids TODO APIs")
	@DeleteMapping("/delete/{tid}")
	public String delete(@PathVariable("tid") Integer id) {
		return this.service.deleteToDoById(id);
		
	}
	

}
