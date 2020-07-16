package com.samcancode.msscbeerservice.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.samcancode.msscbeerservice.domain.Beer;
import com.samcancode.msscbeerservice.repository.BeerRepository;
import com.samcancode.msscbeerservice.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
	private final BeerRepository beerRepo;
	
	public BeerServiceImpl(BeerRepository beerRepo) {
		this.beerRepo = beerRepo;
	}

	@Override
	public BeerDto getBeerById(UUID beerId) {
		Optional<Beer> beer = beerRepo.findById(beerId);
		
		if(beer.isPresent()) {
		return BeerDto.builder().id(beer.get().getId())
				.beerName(beer.get().getBeerName())
				.beerStyle(beer.get().getBeerStyle())
				.price(beer.get().getPrice())
				.quantityOnHand(beer.get().getMinOnHand())
				.upc(beer.get().getUpc())
				.build();
		}
		else {
			return null;
		}
	}

	@Override
	public BeerDto save(BeerDto beerDto) {
		Beer beer = Beer.builder()
						.beerName(beerDto.getBeerName())
						.beerStyle(beerDto.getBeerStyle())
						.minOnHand(beerDto.getQuantityOnHand())
						.price(beerDto.getPrice())
						.quantityToBrew(300 - beerDto.getQuantityOnHand())
						.upc(beerDto.getUpc())
						.build();
		Beer savedBeer = beerRepo.save(beer);
		
		beerDto.setId(savedBeer.getId());
		
		return beerDto;
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
