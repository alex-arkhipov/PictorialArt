package com.alexarkhipov.works.pictorialart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexarkhipov.works.pictorialart.dao.ProductionDao;
import com.alexarkhipov.works.pictorialart.model.Production;
import com.alexarkhipov.works.pictorialart.service.ProductionService;

@Service
public class ProductionServiceImpl implements ProductionService {

	@Autowired
	private ProductionDao productionDao;

	@Override
	public List<Production> getProductions() {
		return productionDao.getProductions();
	}
	
	@Override
	public List<Production> getProductions(Integer qty){
		return productionDao.getProductions(qty);
	}

	@Override
	public Production getProduction(Integer prodId) {
		return productionDao.getProduction(prodId);
	}

	@Override
	public Production getProductionEx(Integer prodId) {
		return productionDao.getProductionEx(prodId);
	}

	@Override
	public List<Production> getProductions(String author) {
		return productionDao.getProductions(author);
	}

	public void saveProduction(Production p) {
		productionDao.saveProduction(p);
	}
}
