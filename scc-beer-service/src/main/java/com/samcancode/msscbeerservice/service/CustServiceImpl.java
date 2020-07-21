package com.samcancode.msscbeerservice.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.samcancode.msscbeerservice.domain.Customer;
import com.samcancode.msscbeerservice.repository.CustomerRepository;
import com.samcancode.msscbeerservice.web.model.CustomerDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustServiceImpl implements CustService {
	private final CustomerRepository custRepo;
	
	public CustServiceImpl(CustomerRepository custRepo) {
		this.custRepo = custRepo;
	}

	@Override
	public CustomerDto getCustById(UUID custId) {
		Optional<Customer> cust = custRepo.findById(custId);
		
		if (cust.isPresent()) {
			return CustomerDto.builder()
								.id(custId)
								.name(cust.get().getName())
								.build();
		}
		
		return null;
	}

	@Override
	public CustomerDto save(CustomerDto custDto) {
		Customer cust = Customer.builder()
								.name(custDto.getName())
								.build();
		Customer savedCust = custRepo.save(cust);
		
		return CustomerDto.builder()
				.id(savedCust.getId())
				.name(savedCust.getName())
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
