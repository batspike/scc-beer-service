package com.samcancode.msscbeerservice.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.samcancode.msscbeerservice.web.model.BeerDto;
import com.samcancode.msscbeerservice.web.model.BeerStyleEnum;

@SpringBootTest
@AutoConfigureMockMvc
class BeerControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;

	@Test
	void testGetBeerById() throws Exception {
		mockMvc.perform(get("/api/v1/beer/"+ UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
			   .andExpect(status().isOk());
	}

	@Test
	void testSaveNewBeer() throws Exception {
		BeerDto beerDto = BeerDto.builder()
				.upc(321200001L)
				.price(new BigDecimal("12.29"))
				.quantityOnHand(200)
				.beerName("Tiger Beer")
				.beerStyle(BeerStyleEnum.PALE_ALE)
				.build();
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);
		
		mockMvc.perform(post("/api/v1/beer/").contentType(MediaType.APPLICATION_JSON).content(beerDtoJson))
			   .andExpect(status().isCreated());
	}

	@Test
	void testUpdateBeerById() throws Exception {
		BeerDto beerDto = BeerDto.builder()
				.upc(321200002L)
				.price(new BigDecimal("13.99"))
				.quantityOnHand(300)
				.beerName("Best Beer")
				.beerStyle(BeerStyleEnum.PALE_ALE)
				.build();
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);
		
		mockMvc.perform(put("/api/v1/beer/"+ UUID.randomUUID().toString()).contentType(MediaType.APPLICATION_JSON).content(beerDtoJson))
			   .andExpect(status().isNoContent());
	}

	@Test
	void testDeleteBeerById() throws Exception {
		mockMvc.perform(delete("/api/v1/beer/"+ UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
		   .andExpect(status().isNoContent());
	}

}
