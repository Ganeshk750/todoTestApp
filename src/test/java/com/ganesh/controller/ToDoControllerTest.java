package com.ganesh.controller;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.net.URI;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.ganesh.dto.DtoToDo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ToDoControllerTest {
	
//	@LocalServerPort
//	private int port;
//	
//	private String baseUrl = "http://localhost";
//	
//	private static RestTemplate restTemplate = null;
//	
//	@BeforeAll
//	public static void init() {
//		restTemplate = new RestTemplate();
//		restTemplate.setErrorHandler(new DefaultResponseErrorHandler(){
//			
//			@Override
//			protected boolean hasError(HttpStatus statusCode) {
//				return false;
//			}
//		});
//	}
//	
//	@BeforeEach
//	public void setUp() {
//		baseUrl = baseUrl.concat(":").concat(port+"").concat("/todos");
//	}
//	
//	@Test
//	@Sql(statements  = "INSERT INTO todo (id, title, done) VALUES(1, 'Spring Boot', TRUE)",  executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//	@Sql(statements = "DELETE FROM todo", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//	public void returnAToDoWithIdOne() {
//		DtoToDo toDoResponse = restTemplate.getForObject(baseUrl.concat("/{todoId}"), DtoToDo.class, 1);
//		System.out.println(toDoResponse);
//		assertAll(
//				() -> assertNotNull(toDoResponse),
//				() -> assertEquals("Spring Boot", toDoResponse.getTitle())
//				);
//	}
//	
//	
//	@Test
//	public void return404() {
//		ResponseEntity<String> err = restTemplate.getForEntity(baseUrl.concat("/{todoId}"), String.class, 1);
//	    assertAll(
//	    		  () -> assertNotNull(err),
//	    		  () -> assertEquals(HttpStatus.NOT_FOUND, err.getStatusCode()),
//	    		  () -> assertNull(err.getBody())
//	    		);
//	}
//	
//	
//	@Test
//	public void createNewToDoAndReturn201HttpStatus() {
//		DtoToDo dtoTodo = new DtoToDo(1, "Spring Boot" , true);
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<DtoToDo> postRequest = new HttpEntity<DtoToDo>(dtoTodo, headers);
//		URI uri = restTemplate.postForLocation(baseUrl, postRequest, DtoToDo.class);
//		System.out.println("URI: "+ uri);
//		assertNotNull(uri);
//		
//	    DtoToDo newDtoToDo = restTemplate.getForObject(uri, DtoToDo.class);
//	    assertAll(
//	    		  () -> assertNotNull(newDtoToDo),
//	    		  () -> assertEquals(dtoTodo.getTitle(), dtoTodo.getTitle()),
//	    		  () -> assertEquals(dtoTodo.isDone(), dtoTodo.isDone())
//	    		);
//	}
//	
	

}
