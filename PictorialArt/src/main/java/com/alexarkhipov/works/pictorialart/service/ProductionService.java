package com.alexarkhipov.works.pictorialart.service;

import java.util.List;

import com.alexarkhipov.works.pictorialart.model.Production;

public interface ProductionService {
	List<Production> getProductions();

	// Return 'productions' of particular 'author'
	List<Production> getProductions(String author);

	public Production getProduction(Integer prodId);

	public Production getProductionEx(Integer prodId);

	public void saveProduction(Production p);
}
