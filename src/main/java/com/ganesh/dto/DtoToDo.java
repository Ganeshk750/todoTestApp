package com.ganesh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoToDo {
	
	private Integer id;
	private String title;
	private boolean done;

}
