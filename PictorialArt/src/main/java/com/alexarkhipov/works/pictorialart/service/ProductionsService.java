package com.alexarkhipov.works.pictorialart.service;

import java.util.List;

import com.alexarkhipov.works.pictorialart.model.Production;

public interface ProductionsService {
	List<Production> getProductions();

	// Return 'productions' of particular 'author'
	List<Production> getProductions(String author);
}
