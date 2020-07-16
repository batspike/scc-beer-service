package com.samcancode.msscbeerservice.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samcancode.msscbeerservice.service.CustService;
import com.samcancode.msscbeerservice.web.model.CustomerDto;


@RestController
@RequestMapping("/api/v1/cust")
public class CustomerController {
	private final CustService custService;
	
	public CustomerController(CustService custService) {
		this.custService = custService;
	}
	
	@GetMapping("/{custId}")
	public ResponseEntity<CustomerDto> getCustById(@PathVariable("custId") UUID custId) {
		return new ResponseEntity<>(custService.getCustById(custId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CustomerDto> saveNewCust(@Valid @RequestBody CustomerDto custDto) {
		CustomerDto savedCust = custService.save(custDto);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/cust/" + savedCust.getId().toString());
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{custId}")
	public ResponseEntity<CustomerDto> updateBeerById(@PathVariable("custId") UUID custId,
												  @Valid @RequestBody CustomerDto custDto) {
		custService.update(custId, custDto);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{custId}")
	public ResponseEntity<CustomerDto> deleteCustById(@PathVariable("custId") UUID custId) {
		custService.delete(custId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	//Validation Exception handling
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<List<String>> validationErrorHandler(ConstraintViolationException e) {
		List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
		
		e.getConstraintViolations()
			.forEach( 
					  constraintViolation -> errors.add( constraintViolation.getPropertyPath() +
														 " : " + 
														 constraintViolation.getMessage())
					);
		
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

}
