package pl.coderslab.sportsbet2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.coderslab.sportsbet2.converter.DateConverter;

//@EnableWebMvc
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter  {

    @Bean
    public DateConverter getDateConverter() {
        return new DateConverter();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/403").setViewName("error/403");
        registry.addViewController("/500").setViewName("error/500");
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addFormatters (FormatterRegistry registry) {
        registry.addConverter(getDateConverter());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/webjars/**",
                "/img/**",
                "/css/**",
                "/js/**",
                "/vendor/**",
                "/static/img/**",
                "/fixture-stats/vendor/**",
                "/fixture-stats/css/**",
                "/fixture-stats/static/img/**",
                "/user-edit/vendor/**",
                "/user-edit/**",
                "/user-edit/css/**",
                "/user-edit/js/**",
                "/fixture-edit/vendor/**",
                "/fixture-edit/css/**",
                "/fixture-edit/static/img/**",
                "/fixture-edit/**")
                .addResourceLocations(
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/",
                        "classpath:/static/vendor/");
    }

}