package com.alexarkhipov.works.pictorialart;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import com.alexarkhipov.works.pictorialart.utils.NeoCrypt;
import com.alexarkhipov.works.pictorialart.utils.NeoCryptImpl;

@Configuration
public class BeanConfig extends WebMvcConfigurerAdapter {

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

	@Bean
	public AmazonS3Helper amazonS3Helper() {
		return new AmazonS3Helper();
	}

	/*
	 * @Bean
	 * 
	 * @Description("Thymeleaf Template Resolver") public
	 * ServletContextTemplateResolver templateResolver() {
	 * ServletContextTemplateResolver templateResolver = new
	 * ServletContextTemplateResolver(); templateResolver.setPrefix("templates/");
	 * templateResolver.setSuffix(".html");
	 * templateResolver.setTemplateMode("HTML5");
	 * templateResolver.setCharacterEncoding("UTF-8");
	 * 
	 * return templateResolver; }
	 * 
	 * @Bean
	 * 
	 * @Description("Thymeleaf Template Engine") public SpringTemplateEngine
	 * templateEngine() { SpringTemplateEngine templateEngine = new
	 * SpringTemplateEngine();
	 * templateEngine.setTemplateResolver(templateResolver()); return
	 * templateEngine; }
	 */

	@Bean
	@Description("Thymeleaf View Resolver")
	public ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setContentType("text/html; charset=UTF-8");
		viewResolver.setCharacterEncoding("UTF-8");
		return viewResolver;
	}
}
