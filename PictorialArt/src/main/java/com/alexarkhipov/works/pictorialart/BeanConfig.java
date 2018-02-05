package com.alexarkhipov.works.pictorialart;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alexarkhipov.works.pictorialart.utils.NeoCrypt;
import com.alexarkhipov.works.pictorialart.utils.NeoCryptImpl;

@Configuration
public class BeanConfig {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Bean
	public SessionFactory getSessionFactory() {
		SessionFactory sf = entityManagerFactory.unwrap(SessionFactory.class);
		if (sf == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		return sf;
	}

	@Bean
	@Autowired
	public NeoCrypt neoCrypt(@Value("${app.hash.iterations}") String hashIterations,
			@Value("${app.hash.length}") String hashLength) {
		int hi = Integer.parseInt(hashIterations);
		int hl = Integer.parseInt(hashLength);
		return new NeoCryptImpl(hi, hl);
	}
}
