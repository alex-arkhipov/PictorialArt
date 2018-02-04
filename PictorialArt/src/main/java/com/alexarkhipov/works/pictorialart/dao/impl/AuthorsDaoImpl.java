package com.alexarkhipov.works.pictorialart.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alexarkhipov.works.pictorialart.dao.AuthorsDao;
import com.alexarkhipov.works.pictorialart.model.Author;

@Component
public class AuthorsDaoImpl implements AuthorsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Author> getAuthors() {
		Criteria criteria = sessionFactory.openSession().createCriteria(Author.class);
		return criteria.list();
	}

}
