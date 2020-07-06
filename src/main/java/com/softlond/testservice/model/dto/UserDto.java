package com.softlond.testservice.model.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserDto {
	
	private String name;
	private String lastName;
	private String directionOfHouse;
	
	public UserDto() {}
	
	public UserDto(String name, String lastName) {
		super();
		this.name = name;
		this.lastName = lastName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDirectionOfHouse() {
		return directionOfHouse;
	}

	public void setDirectionOfHouse(String directionOfHouse) {
		this.directionOfHouse = directionOfHouse;
	}
	
}
