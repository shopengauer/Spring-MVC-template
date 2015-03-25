/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pavlov.springmvcjavaconfig.web;


import org.pavlov.springmvcjavaconfig.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author pavlov
 */
@Controller
@RequestMapping(value = "/form")
public class NewController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String register(Model model) {
        User user = new User();
        user.setPassword("Qwas");
        model.addAttribute("user", user);
        return "form/new";
    }
    
    
}
