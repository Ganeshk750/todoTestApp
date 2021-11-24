package com.ganesh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class ToDo {
	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private boolean done;

}
