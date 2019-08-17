package com.mars.robot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class RobotApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void robotMoveToRightSuccess() throws Exception{
		String commands = "MMRMMRMM";
		this.mockMvc.perform(post("/rest/mars/{commands}", commands))        
        .andExpect(status().isOk())
        .andExpect(content().string("(2, 0, S)"));
	}
	
	@Test
	void robotMoveToLeftSuccess() throws Exception{
		String commands = "MML";
		this.mockMvc.perform(post("/rest/mars/{commands}", commands))
		.andExpect(status().isOk())
        .andExpect(content().string("(0, 2, W)"));
	}
	
	@Test
	void failRobotCommandInvalid() throws Exception{
		String commands = "AAA";
		this.mockMvc.perform(post("/rest/mars/{commands}", commands))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	void failRobotCommandInvalidPosition() throws Exception{
		String commands = "MMMMMMMMMMMMMMMMMMMMMMMM";
		this.mockMvc.perform(post("/rest/mars/{commands}", commands))
		.andExpect(status().isBadRequest());
	}
}
