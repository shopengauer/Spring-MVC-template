/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pavlov.springmvcjavaconfig.config;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.pavlov.springmvcjavaconfig.model.User;
import org.pavlov.springmvcjavaconfig.qualifiers.UserMap;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 *
 * @author pavlov
 */
@Configuration
@EnableWebMvc
@ComponentScan("org.pavlov.springmvcjavaconfig.web")
class WebConfig extends WebMvcConfigurerAdapter{

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
        
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
       
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".xhtml");
//        resolver.setExposeContextBeansAsAttributes(true);
//        registry.viewResolver(resolver);
        
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".xhtml");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCharacterEncoding("UTF-8");
        
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        viewResolver.setCharacterEncoding("UTF-8");
        registry.viewResolver(viewResolver);
    
    
    }
 
     @Bean
     @Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS) 
     public User user(){
//         User user = new User();
//         user.setUserName("Kaka");
        return new User();
     } 

    @Override
    public void addFormatters(FormatterRegistry registry) {
         super.addFormatters(registry); //To change body of generated methods, choose Tools | Templates.
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource rrbm = new ReloadableResourceBundleMessageSource();
        rrbm.setBasename("locale/ApplicationMessageSource");
        rrbm.setDefaultEncoding("UTF-8");
        return rrbm;
    }
     
    @Bean
    public SessionLocaleResolver localeResolver(){
        SessionLocaleResolver slr = new SessionLocaleResolver();
        //Locale locale = new Locale("RU");
        slr.setDefaultLocale(Locale.ENGLISH);
   
        return slr;
        
    }

}
