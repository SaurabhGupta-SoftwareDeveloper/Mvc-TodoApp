package todo.configuragtion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@ComponentScan("todo")
public class MySpringContainerConfiguration {
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/view/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	  @Bean
	    public EntityManager getEntityManager() {
	    	EntityManagerFactory factory=Persistence.createEntityManagerFactory("karthik");
	    	EntityManager manager=factory.createEntityManager();
	    	return manager;
	    }

}
