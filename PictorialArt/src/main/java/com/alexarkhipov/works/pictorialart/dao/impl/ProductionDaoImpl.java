/**
 * 
 */
package com.alexarkhipov.works.pictorialart.dao.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alexarkhipov.works.pictorialart.AmazonS3Helper;
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

	@Autowired
	private AmazonS3Helper s3Helper;

	@SuppressWarnings("unchecked")
	public List<Production> getProductions() {
		List<Production> l = null;
		try (Session s = sessionFactory.openSession()) {
			Criteria criteria = s.createCriteria(Production.class);
			l = criteria.list();
		}
		return l;
	}

	public List<Production> getProductions(Integer qty) {
		List<Production> l = getProductions();
		int size = l.size();
		
		if (qty > size) {
			// Error - number of productions is smaller than requested value
			return l;
		}
		
		Production[] a = new Production[size];
		l.toArray(a);
		
		List <Production> l2 = new ArrayList<>();
		
		Random rand = new Random();
		int r = 0;
		for(int i=0;i<qty;i++) {
			// Get new random value
			// Check that is was not choosed before - if so regereneate random
			do {
				r = rand.nextInt(size);	
			} while (a[r] == null);
			
			// Copy element to new List
			l2.add(a[r]);
			a[r] = null;
			
		}
		
		return l2;
	}
	
	public Production getProduction(Integer prodId) {
		Production p = null;
		try (Session s = sessionFactory.openSession()) {
			p = getProductionUnsafe(s, prodId);
		}
		return p;
	}

	public Production getProductionEx(Integer prodId) {
		Production p = null;

		try (Session s = sessionFactory.openSession()) {
			// Get usual production
			p = getProductionUnsafe(s, prodId);

			// Fill in URL part
			p.setImageUrl(s3Helper.getImageUrl(prodId.toString()));
		}
		return p;
	}

	private Production getProductionUnsafe(Session s, Integer prodId) {
		Criteria criteria = s.createCriteria(Production.class);
		return (Production) criteria.add(Restrictions.eq("id", prodId)).uniqueResult();
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
