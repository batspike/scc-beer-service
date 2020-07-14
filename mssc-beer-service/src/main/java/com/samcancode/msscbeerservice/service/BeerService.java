package com.samcancode.msscbeerservice.service;

import java.util.UUID;

import com.samcancode.msscbeerservice.web.model.BeerDto;

public interface BeerService {
	BeerDto getBeerById(UUID beerId);

	BeerDto save(BeerDto beerDto);

	void update(UUID beerId, BeerDto beerDto);

	void delete(UUID beerId);
}
