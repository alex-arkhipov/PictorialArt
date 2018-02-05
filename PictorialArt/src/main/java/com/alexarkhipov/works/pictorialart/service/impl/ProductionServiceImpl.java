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
	private ProductionDao producationsDao;

	@Override
	public List<Production> getProductions() {
		return producationsDao.getProductions();
	}

	@Override
	public List<Production> getProductions(String author) {
		return producationsDao.getProductions(author);
	}

}
