package com.alexarkhipov.works.pictorialart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexarkhipov.works.pictorialart.dao.ProductionsDao;
import com.alexarkhipov.works.pictorialart.model.Production;
import com.alexarkhipov.works.pictorialart.service.ProductionsService;

@Service
public class ProductionsServiceImpl implements ProductionsService {

	@Autowired
	private ProductionsDao producationsDao;

	@Override
	public List<Production> getProductions() {
		return producationsDao.getProductions();
	}

	@Override
	public List<Production> getProductions(String author) {
		return producationsDao.getProductions(author);
	}

}
