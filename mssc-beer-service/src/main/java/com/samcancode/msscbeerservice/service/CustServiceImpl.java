package com.samcancode.msscbeerservice.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.samcancode.msscbeerservice.web.model.CustomerDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustServiceImpl implements CustService {

	@Override
	public CustomerDto getCustById(UUID custId) {
		return CustomerDto.builder()
							.id(custId)
							.name("Paul Walker")
							.build();
	}

	@Override
	public CustomerDto save(CustomerDto custDto) {
		log.info("Saving customer id: "+ custDto.getId());
		
		return CustomerDto.builder()
				.id(UUID.randomUUID())
				.name(custDto.getName())
				.build();
	}

	@Override
	public void update(UUID custId, CustomerDto custDto) {
		log.info("Updating customer id: "+ custId);
	}

	@Override
	public void delete(UUID custId) {
		log.info("Deleting customer id: "+ custId);
	}

}
