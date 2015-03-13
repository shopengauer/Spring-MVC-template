/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pavlov.springmvcjavaconfig.config;

import java.util.HashMap;
import java.util.Map;
import org.pavlov.springmvcjavaconfig.qualifiers.UserMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author pavlov
 */
@Configuration
@ComponentScan(basePackages={"org.pavlov.springmvcjavaconfig"},
excludeFilters={@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)})
class RootConfig {
    
    @Bean
    @UserMap
    public Map<String,String> userMap(){
        Map<String,String> map = new HashMap<>();
        map.put("Wasiliy", "pavlov@matritca.ru");
        map.put("Serafim", "MichalovSV@matritca.ru");
        map.put("Konstantin", "yudaev@matritca.ru");
        map.put("Sergey", "AfanasevSA@matritca.ru");
        return map;
    }
    
//    @Bean
//    public String user(){
//        return "Wasiliy";
//    }
    
    
}
