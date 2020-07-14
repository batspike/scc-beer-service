package com.samcancode.msscbeerservice.service;

import java.util.UUID;

import com.samcancode.msscbeerservice.web.model.CustomerDto;

public interface CustService {
	CustomerDto getCustById(UUID custId);

	CustomerDto save(CustomerDto custDto);

	void update(UUID custId, CustomerDto custDto);

	void delete(UUID custId);
}
