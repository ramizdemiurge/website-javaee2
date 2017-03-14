package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("Controllers")
public class WebAppConfig extends WebMvcConfigurerAdapter
{

    // Позволяет видеть все ресурсы в папке pages, такие как картинки, стили и т.п.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        registry.addResourceHandler("/templates/**").addResourceLocations("/WEB-INF/templates/");
        registry.addResourceHandler("/assets/**").addResourceLocations("/WEB-INF/templates/assets/");
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/templates/assets/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/templates/assets/js/");
        registry.addResourceHandler("/docs/**").addResourceLocations("/WEB-INF/docs/");
        registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/templates/assets/img/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("forward:/index.html");
    }


    // а этот бин инициализирует View нашего проекта
    // точно это же мы делали в mvc-dispatcher-servlet.xml
    @Bean
    public InternalResourceViewResolver setupViewResolver()
    {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);

        return resolver;
    }

}