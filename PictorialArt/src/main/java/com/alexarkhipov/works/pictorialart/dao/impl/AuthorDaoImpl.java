package com.alexarkhipov.works.pictorialart.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alexarkhipov.works.pictorialart.dao.AuthorDao;
import com.alexarkhipov.works.pictorialart.model.Author;
import com.alexarkhipov.works.pictorialart.model.Production;

@Component
public class AuthorDaoImpl implements AuthorDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Author> getAuthors() {
		List<Author> l = new ArrayList<>();

		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(Author.class);
			l = criteria.list();
		}
		return l;
	}

	public Author getAuthor(Integer id) {
		Author a = null;
		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(Author.class);
			criteria.add(Restrictions.eq("id", id));
			a = (Author) criteria.uniqueResult();
		}
		return a;
	}
	
	public void save(Author a) {
		Session s = sessionFactory.openSession();
		s.getTransaction().begin();
		s.save(a);
		s.getTransaction().commit();
		s.close();
	}

}
