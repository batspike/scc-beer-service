package com.samcancode.msscbeerservice.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.samcancode.msscbeerservice.web.model.CustomerDto;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;

	@Test
	void testGetCustById() throws Exception {
		mockMvc.perform(get("/api/v1/cust/"+ UUID.randomUUID()).accept(MediaType.APPLICATION_JSON))
			   .andExpect(status().isOk());
	}

	@Test
	void testSaveNewCust() throws Exception {
		CustomerDto custDto = CustomerDto.builder().id(null).name("New Customer").build();
		String custDtoJson = objectMapper.writeValueAsString(custDto);
		
		mockMvc.perform(post("/api/v1/cust/").contentType(MediaType.APPLICATION_JSON).content(custDtoJson))
			   .andExpect(status().isCreated());
	}

	@Test
	void testUpdateCustById() throws Exception {
		CustomerDto custDto = CustomerDto.builder().id(UUID.randomUUID()).name("Updated Customer").build();
		String custDtoJson = objectMapper.writeValueAsString(custDto);
		
		mockMvc.perform(put("/api/v1/cust/"+ UUID.randomUUID().toString()).contentType(MediaType.APPLICATION_JSON).content(custDtoJson))
			   .andExpect(status().isNoContent());
	}

	@Test
	void testDeleteCustById() throws Exception {
		mockMvc.perform(delete("/api/v1/cust/"+ UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
		   .andExpect(status().isNoContent());
	}

}
