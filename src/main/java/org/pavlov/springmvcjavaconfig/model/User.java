/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pavlov.springmvcjavaconfig.model;

 
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author pavlov
 */
 //@Component
//@Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User{
    
    @NotNull
    @NotEmpty(message = "Enter your first name")
    //@Size(min = 2,max = 15,message = "Your name must be between 2 and 15 chars")
    private String firstName;
    
    @NotNull
    @NotEmpty(message = "Enter your last name")
    //@Size(min = 2,max = 15)
    private String lastName;
    
    @NotNull
    @NotEmpty
    @Size(min = 2,max = 15,message = "Your username must be between 2 and 15 chars")
    private String userName;
    
    @NotNull
    @NotEmpty
    @Size(min = 5,max = 15,message = "Your password must be between 2 and 15 symbols")
    private String password;
    
     
    private String passVerify;
 
 //   @AssertTrue(message = "Passwords not match")
    private boolean pasValid;  
    
    public User() {
           
    }
 
   
   // @AssertTrue(message = "Passwords not match")
//    public boolean isPasValid() {
//        pasValid = this.password.equals(passVerify);
//        return pasValid;
//    }
//
//    public void setPasValid(boolean pasValid) {
//        this.pasValid = pasValid;
//    }

    @AssertTrue(message = "Passwords not match")
    public boolean isPasValid() {
        return pasValid;
    }

    public void setPasValid(boolean pasValid) {
        this.pasValid = pasValid;
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
