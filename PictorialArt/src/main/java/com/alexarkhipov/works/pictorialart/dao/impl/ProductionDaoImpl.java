/**
 * 
 */
package com.alexarkhipov.works.pictorialart.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alexarkhipov.works.pictorialart.dao.ProductionDao;
import com.alexarkhipov.works.pictorialart.model.Production;

/**
 * @author arkhipov
 *
 */
@Component
public class ProductionDaoImpl implements ProductionDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Production> getProductions() {
		Criteria criteria = sessionFactory.openSession().createCriteria(Production.class);
		return criteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.alexarkhipov.works.pictorialart.dao.ProductionsDao#getProductions(java.
	 * lang.String)
	 */
	@Override
	public List<Production> getProductions(String author) {
		// TODO Auto-generated method stub
		return new LinkedList<>();
	}

}
