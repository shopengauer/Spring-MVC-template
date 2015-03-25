/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pavlov.springmvcjavaconfig.config;

import javax.servlet.Filter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author pavlov
 */
public class Config extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
      return new Class<?>[] { RootConfig.class };    
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
      return new Class<?>[] { WebConfig.class };   
    }

    @Override
    protected String[] getServletMappings() {
       return new String[] { "/" };    
    }

    @Override
    protected WebApplicationContext createServletApplicationContext() {
        return super.createServletApplicationContext(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Filter[] getServletFilters() {
        
        CharacterEncodingFilter cef = new CharacterEncodingFilter();
        cef.setEncoding("UTF-8");
        Filter[] filters = new Filter[]{cef};      
        return filters; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
