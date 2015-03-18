/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pavlov.springmvcjavaconfig.web;

import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import org.pavlov.springmvcjavaconfig.model.User;
import org.pavlov.springmvcjavaconfig.qualifiers.UserMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author pavlov
 */
@Controller
public class HomeController {

    @Autowired
    @UserMap
    @Value("#{userMap}")
    private  Map<String,String> userMap;
    
    @Autowired
    private Validator validator;
        
    @Autowired
    private  User user;
  
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("user", this.user);
        return "home";
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String signIn(User user, Errors errors,RedirectAttributes model) {
         
       
     Set<ConstraintViolation<User>> constraintUserUsername = 
             validator.validateProperty(user, "userName");

    // errors.rejectValue("userName", "Not appropriate");
 
//      constraintUserUsername.size();
//              
        if (constraintUserUsername.isEmpty()) {
           // model.addFlashAttribute(user);
            return "redirect:index";
          
        } 
         
        return "home";
       
        
    }
    
    
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String submitRegister(@Valid User user, Errors errors) {
        
    if (errors.hasErrors()) {
            return "registerForm";
          
        } 
         
        return "index";
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        
        return "index";
    }
 

    public Map<String, String> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, String> userMap) {
        this.userMap = userMap;
    }

    public Validator getValidator() {
        return validator;
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
    
    
    
}
