package todo.configuragtion;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyConfigurationclass extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{MySpringContainerConfiguration.class};
		
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return  new String []{"/"};
	}

}
