package com.alexarkhipov.works.pictorialart.service;

import java.util.List;

import com.alexarkhipov.works.pictorialart.model.Production;

public interface ProductionService {
	List<Production> getProductions();

	public Production getProduction(Integer prodId);

	// Return 'productions' of particular 'author'
	List<Production> getProductions(String author);

	public void saveProduction(Production p);
}
