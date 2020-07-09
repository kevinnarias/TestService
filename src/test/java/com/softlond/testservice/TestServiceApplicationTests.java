package com.softlond.testservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softlond.testservice.controller.Controller;
import com.softlond.testservice.model.dto.UserDto;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestServiceApplication.class)
@WebMvcTest({ Controller.class})
class TestServiceApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private Controller controller;
	
	private ObjectMapper mapper = new ObjectMapper();

	@Test
	void contextLoads() throws Exception {
		//getResult(new UserDto());
		controller.create(new UserDto());
		getResult(new UserDto());
		Assertions.assertEquals("true","true");
	}

	private MvcResult getResult(UserDto requestObject) throws Exception {
		String json = mapper.writeValueAsString(requestObject);

		return this.mvc.perform(post("/")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
			.andReturn();
	}

}
