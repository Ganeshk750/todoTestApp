package com.ganesh.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.ganesh.model.ToDo;


@DataJpaTest
public class ToDoRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ToDoRepository repository;
	
	
	@Test
	public void shouldFindNumbrOfTodoIfRepositoryIsEmpty() {
		Iterable<ToDo> todos = repository.findAll();
		assertThat(todos).isEmpty();
	}
	
	@Test
	public void shouldStoreAToDo() {
		ToDo todo = new ToDo("Spring Boot", true);
		ToDo todos = repository.save(todo);
		assertThat(todos).hasFieldOrPropertyWithValue("title", "Spring Boot");
		assertThat(todos).hasFieldOrPropertyWithValue("done", true);
	}
	
	@Test
	public void shouldFindAllTutorials() {
		ToDo t1 = new ToDo("Spring Boot", true);
		entityManager.persist(t1);
		ToDo t2 = new ToDo("Hibernate", true);
		entityManager.persist(t2);
		Iterable<ToDo> todos = repository.findAll();
		assertThat(todos).hasSize(2).contains(t1, t2);
	}
	
	@Test
	public void shouldFindToDoById() {
		ToDo t1 = new ToDo("Spring Boot", true);
		entityManager.persist(t1);
		ToDo t2 = new ToDo("Hibernate", true);
		entityManager.persist(t2);
		ToDo result = repository.findById(t1.getId()).get();
		assertThat(result).isEqualTo(t1);
	}
	
	@Test
	public void shouldDeleteAllToDos() {
		entityManager.persist(new ToDo("Desc#1", true));
		entityManager.persist(new ToDo("Desc#2", false));
		repository.deleteAll();
		assertThat(repository.findAll()).isEmpty();

	}
	
	@Test
	public void shouldDeleteByIdOfToDo() {
		ToDo t1 = entityManager.persist(new ToDo("TEST 1", true));
		ToDo t2 = entityManager.persist(new ToDo("TEST 2", false));
		repository.deleteById(t1.getId());
		assertThat(repository.findAll()).hasSize(1);

	}
	
	@Test
	public void shouldUpdateToDoById() {
		ToDo t1 = entityManager.persist(new ToDo("TEST 1", true));
		ToDo t2 = entityManager.persist(new ToDo("TEST 2", false));
		
	    ToDo updateToDo = new ToDo("TEST 3", false);
	    ToDo todo = repository.findById(t1.getId()).get();
	    todo.setTitle(updateToDo.getTitle());
	    todo.setDone(updateToDo.isDone());
	    repository.save(todo);
	    
	    // Now Checking
	    
	    ToDo checkToDo = repository.findById(t1.getId()).get();
	    assertThat(checkToDo.getId()).isEqualTo(t1.getId());
	    assertThat(checkToDo.getTitle()).isEqualTo(t1.getTitle());
	    assertThat(checkToDo.isDone()).isEqualTo(t1.isDone());
	}
	

}
