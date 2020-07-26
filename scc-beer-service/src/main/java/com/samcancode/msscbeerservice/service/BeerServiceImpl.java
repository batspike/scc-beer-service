package com.samcancode.msscbeerservice.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.samcancode.msscbeerservice.repository.BeerRepository;
import com.samcancode.msscbeerservice.web.mapper.BeerMapper;
import com.samcancode.msscbeerservice.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
	private final BeerRepository beerRepo;
	private final BeerMapper beerMapper;
	
	public BeerServiceImpl(BeerRepository beerRepo, BeerMapper beerMapper) {
		this.beerRepo = beerRepo;
		this.beerMapper = beerMapper;
	}

	@Override
	public BeerDto getBeerById(UUID beerId) {
		return beerMapper.beerToBeerDto(beerRepo.findById(beerId).orElse(null));
	}

	@Override
	public BeerDto save(BeerDto beerDto) {
		return beerMapper.beerToBeerDto(beerRepo.save(beerMapper.beerDtoToBeer(beerDto)));
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
