package com.alexarkhipov.works.pictorialart.service;

import com.alexarkhipov.works.pictorialart.model.Description;

public interface DescriptionService {

	public Description getDescription(Integer dId);

	public void saveDescription(Description p);

	public Description saveDescription(String desc);
}
