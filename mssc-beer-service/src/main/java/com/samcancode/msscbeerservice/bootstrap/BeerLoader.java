package com.samcancode.msscbeerservice.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.samcancode.msscbeerservice.domain.Beer;
import com.samcancode.msscbeerservice.repository.BeerRepository;

@Component
public class BeerLoader implements CommandLineRunner {
	private final BeerRepository beerRepo;
	
	public BeerLoader(BeerRepository beerRepo) {
		this.beerRepo = beerRepo;
	}


	@Override
	public void run(String... args) throws Exception {
		loadBeerObjects();
	}


	private void loadBeerObjects() {
		if(beerRepo.count() == 0) {
			
			beerRepo.save(Beer.builder()
					.beerName("Mango Bobs")
					.beerStyle("IPA")
					.quantityToBrew(200)
					.minOnHand(12)
					.upc(3770099301L)
					.price(new BigDecimal("12.95"))
					.build());
			
			beerRepo.save(Beer.builder()
					.beerName("Galazy Cat")
					.beerStyle("PALE_ALE")
					.quantityToBrew(200)
					.minOnHand(12)
					.upc(3770099302L)
					.price(new BigDecimal("11.95"))
					.build());
			
		}
		
	}
	
}
