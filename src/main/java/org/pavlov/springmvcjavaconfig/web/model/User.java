/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pavlov.springmvcjavaconfig.web.model;

 
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author pavlov
 */
 //@Component
//@Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User{
    
    @NotNull
    @NotEmpty
    @Size(min = 2,max = 15)
    private String firstName;
    
    @NotNull
    @NotEmpty
    @Size(min = 2,max = 15)
    private String lastName;
    
    @NotNull
    @NotEmpty
    @Size(min = 2,max = 15)
    private String userName;
    
    @NotNull
    @NotEmpty
    @Size(min = 5,max = 15)
    private String password;
    
     
    private String passVerify;
 
      
    
    public User() {
    }
 
    @AssertTrue
    public boolean isValid(){
      return this.password.equals(passVerify);
    }
    
    
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassVerify() {
        return passVerify;
    }

    public void setPassVerify(String passVerify) {
        this.passVerify = passVerify;
    }
 

    
    
    
    
}
