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
    
    /**
     * goTo check the log in data and returns a String to the next page
     * @return the next page
     */
    public String goTo(){
        
        // to test the logIn I add some users
        ManagUserList.addUser("Marvin", "password");
        ManagUserList.addUser("Luca", "password");
        ManagUserList.addUser("Erik", "password");
        ManagUserList.addUser("Jan", "password");
        
        // check if the password was correct
        if(ManagUserList.checkLogInData(username, password)){
            System.out.println("hallo" + username);
            return "home";
        }
        return "LogIn";
    }
    
    /**
     * 
     * @param username 
     */
    public void setUsername(String username){
        this.username = username;
    }
    
    /**
     * 
     * @return 
     */
    public String getUsername(){
        return username;
    }
    
    /**
     * 
     * @param password 
     */
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
    
}
