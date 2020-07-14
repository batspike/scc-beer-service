package com.samcancode.msscbeerservice.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.samcancode.msscbeerservice.web.model.BeerDto;
import com.samcancode.msscbeerservice.web.model.BeerStyleEnum;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDto getBeerById(UUID beerId) {
		return BeerDto.builder().id(UUID.randomUUID())
				.beerName("Galaxy Cat")
				.beerStyle(BeerStyleEnum.ALE)
				.build();
	}

	@Override
	public BeerDto save(BeerDto beerDto) {
		log.info("Saving beerId" + beerDto.getId().toString());
		
		return BeerDto.builder().id(UUID.randomUUID())
				.beerName("Tiger Beer")
				.beerStyle(BeerStyleEnum.ALE)
				.build();
	}

	@Override
	public void update(UUID beerId, BeerDto beerDto) {
		log.debug("Updating beerId: " + beerId);
	}

	@Override
	public void delete(UUID beerId) {
		log.debug("Deleting beerId: " + beerId);
	}

}
