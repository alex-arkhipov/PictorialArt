/**
 * 
 */
package com.alexarkhipov.works.pictorialart.dao.impl;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alexarkhipov.works.pictorialart.dao.DescriptionDao;
import com.alexarkhipov.works.pictorialart.model.Description;

/**
 * @author arkhipov
 *
 */
@Component
public class DescriptionDaoImpl implements DescriptionDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Description getDescription(Integer dId) {
		Description d = null;
		try (Session s = sessionFactory.openSession()) {
			Criteria criteria = s.createCriteria(Description.class);
			d = (Description) criteria.add(Restrictions.eq("id", dId)).uniqueResult();
		}
		return d;
	}

	public Integer saveDescription(Description d) {
		Session s = sessionFactory.openSession();
		Serializable id = s.save(d);
		s.close();
		return (Integer) id;
	}

	public Description saveDescription(String desc) {
		Description d = new Description();
		d.setDescription(desc);
		saveDescription(d);
		return d;
	}
}
