/**
 * 
 */
package com.alexarkhipov.works.pictorialart.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		List<Production> l = null;
		try (Session s = sessionFactory.openSession()) {
			Criteria criteria = s.createCriteria(Production.class);
			l = criteria.list();
		}
		return l;
	}

	public Production getProduction(Integer prodId) {
		Production p = null;
		try (Session s = sessionFactory.openSession()) {
			Criteria criteria = s.createCriteria(Production.class);
			p = (Production) criteria.add(Restrictions.eq("id", prodId)).uniqueResult();
		}
		return p;
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

	public void saveProduction(Production p) {
		Session s = sessionFactory.openSession();
		s.getTransaction().begin();
		s.getTransaction().commit();
		s.close();
	}
}
