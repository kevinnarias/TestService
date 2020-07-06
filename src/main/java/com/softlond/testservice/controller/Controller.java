package com.softlond.testservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.softlond.testservice.model.dto.ErrorDto;
import com.softlond.testservice.model.dto.UserDto;

@RestController
public class Controller {
	
	@Value("${properties.myvalue}")
	String value;

	@GetMapping("/{path}")
	public ResponseEntity<String> getWithParams(
			@PathVariable String path,
			@RequestParam String request) {
		
		return ResponseEntity.ok(path.concat(" ").concat(request));
	}
	
	@GetMapping
	public ResponseEntity<UserDto> get(){
		System.out.println(value);
		return ResponseEntity.ok(new UserDto("Kevin", "Arias"));
	}
	
	@PostMapping
	public ResponseEntity<Object> create(
			@Valid @RequestBody UserDto user) {
		//if(user.getName().length()>15) return new ResponseEntity<>(new ErrorDto("Name length max exceeded","400"), HttpStatus.BAD_REQUEST);
		if(user.getName().length()>15) return ResponseEntity.ok(new ErrorDto("Name length max exceeded","400"));
		return ResponseEntity.ok(user);
	}
	
	@PutMapping
	@ResponseBody
	public UserDto update() {
		return new UserDto("Kevin", "Arias3");
	}
	
	@DeleteMapping
	public String delete() {
		return "Delete working";
	}
}
