package com.samcancode.msscbeerservice.validation;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.samcancode.msscbeerservice.web.model.BeerStyleEnum;

public class BeerStyleEnumSubsetValidator implements 
				ConstraintValidator<BeerStyleEnumSubset, BeerStyleEnum> {
	private BeerStyleEnum[] subset;

	@Override
	public void initialize(BeerStyleEnumSubset constraintAnnotation) {
		this.subset = constraintAnnotation.anyOf();
	}

	@Override
	public boolean isValid(BeerStyleEnum value, ConstraintValidatorContext context) {
		return value == null || Arrays.asList(subset).contains(value);
	}
	
	
}
