package ve.com.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletRegistration;

/**
 * Created by 893414 on 4/22/2015.
 */
public class WebInitDescApp extends AbstractAnnotationConfigDispatcherServletInitializer{


    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("dispatchOptionsRequest", "true");
        registration.   setAsyncSupported(true);
    }


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};

    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
