package com.alexarkhipov.works.pictorialart.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alexarkhipov.works.pictorialart.dao.GenreDao;
import com.alexarkhipov.works.pictorialart.model.Genre;

@Component
public class GenreDaoImpl implements GenreDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Genre> getGenres() {
		List<Genre> l = new ArrayList<>();

		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(Genre.class);
			l = criteria.list();
		}
		return l;
	}

	public Genre getGenre(Integer id) {
		Genre g = null;
		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(Genre.class);
			criteria.add(Restrictions.eq("id", id));
			g = (Genre) criteria.uniqueResult();
		}
		return g;
	}

}
