/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package managedBeans;

import de.hsh.steam.services.SteamService;
import java.beans.*;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author jan
 */

@Named(value = "registerBean")
@RequestScoped
public class RegisterBean implements Serializable {
    
    public RegisterBean() {
        
    }
    
    String username;
    String password;

   

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pwd) {
        this.password = pwd;
    }
    
    public void register(){
        SteamService.getInstance().newUser(this.username, this.password);
    }
}
