package com.samcancode.msscbeerservice.web.mapper;

import org.mapstruct.Mapper;

import com.samcancode.msscbeerservice.domain.Customer;
import com.samcancode.msscbeerservice.web.model.CustomerDto;

@Mapper
public interface CustomerMapper {
	CustomerDto customerToCustomerDto(Customer customer);
	Customer    customerDtoToCustomer(CustomerDto customer);
}
