/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author marvinpieper
 */
@Named(value= "checkLogIn")
@SessionScoped
public class CheckLogIn implements Serializable {
    String username;
    String password;
    
    
    public String goTo(){
        return "home";
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String u){
        this.username = u;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String u){
        this.password = u;
    }
}
