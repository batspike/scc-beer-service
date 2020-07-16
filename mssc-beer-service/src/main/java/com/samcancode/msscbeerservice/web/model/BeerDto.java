package com.samcancode.msscbeerservice.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

import com.samcancode.msscbeerservice.validation.BeerStyleEnumSubset;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
	@Null
	private UUID id;
	
	@Positive
	private Integer version;
	
	private OffsetDateTime createdDate;
	private OffsetDateTime lastModifiedDate;
	
	@NotBlank
	private String beerName;
	
	@NotNull
	@BeerStyleEnumSubset(
			anyOf= {BeerStyleEnum.LAGER, BeerStyleEnum.PILSNER, BeerStyleEnum.STOUT, 
					BeerStyleEnum.GOSE, BeerStyleEnum.PORTER, BeerStyleEnum.ALE, 
					BeerStyleEnum.WHEAT, BeerStyleEnum.IPA, BeerStyleEnum.PALE_ALE, 
					BeerStyleEnum.SAISON})
	private BeerStyleEnum beerStyle;
	
	@Positive
	private Long upc;
	
	@Positive
	private BigDecimal price;
	
	@Positive
	private Integer quantityOnHand;
}
