/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pavlov.springmvcjavaconfig.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.pavlov.springmvcjavaconfig.model.User;
import org.pavlov.springmvcjavaconfig.qualifiers.UserMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    
//    @Autowired
//    private  String user;
  
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("user", new User());
        return "home";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
         model.addAttribute("user", new User());
        return "registerForm";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String submitRegister(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("map",new ArrayList<String>().add("sdc"));
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

    
    
    
    
}
