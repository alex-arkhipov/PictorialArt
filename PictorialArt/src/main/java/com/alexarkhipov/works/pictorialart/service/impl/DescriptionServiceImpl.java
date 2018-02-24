package com.alexarkhipov.works.pictorialart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexarkhipov.works.pictorialart.dao.DescriptionDao;
import com.alexarkhipov.works.pictorialart.model.Description;
import com.alexarkhipov.works.pictorialart.service.DescriptionService;

@Service
public class DescriptionServiceImpl implements DescriptionService {

	@Autowired
	private DescriptionDao descriptionDao;

	@Override
	public Description getDescription(Integer dId) {
		return descriptionDao.getDescription(dId);
	}

	public void saveDescription(Description d) {
		descriptionDao.saveDescription(d);
	}

	public Description saveDescription(String desc) {
		return descriptionDao.saveDescription(desc);
	}
}
