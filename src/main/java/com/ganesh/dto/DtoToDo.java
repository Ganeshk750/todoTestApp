package com.ganesh.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Api(value="Todo Model Information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoToDo {
	
	@ApiModelProperty(value="ToDo Id")
	private Integer id;
	@ApiModelProperty(value="ToDo Title")
	private String title;
	@ApiModelProperty(value="ToDo Status")
	private boolean done;

}
