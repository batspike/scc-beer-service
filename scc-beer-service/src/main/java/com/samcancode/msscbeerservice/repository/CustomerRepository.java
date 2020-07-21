package com.samcancode.msscbeerservice.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.samcancode.msscbeerservice.domain.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, UUID> {

}
