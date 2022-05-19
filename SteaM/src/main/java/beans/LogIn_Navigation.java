/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "checkLogIn")
@RequestScoped
public class LogIn_Navigation {
    private String username;
    private String password;
    
    
    public String goTo(){
        ManagUserList.addUser(username, password);
        if(ManagUserList.checkLogInData(username, password)){
            System.out.println("hallo" + username);
            return "home";
        }
        return "LogIn";
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
    
}
