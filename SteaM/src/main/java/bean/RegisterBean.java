/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package bean;

import de.hsh.steam.services.SteamService;
import java.beans.*;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
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
    
    UIComponent registerButton;
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
        boolean isOk = SteamService.getInstance().newUser(this.username, this.password);
        if (isOk) {
            FacesMessage message = new FacesMessage("User created");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(registerButton.getClientId(context), message);
        } else {
            FacesMessage message = new FacesMessage("User already exists");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(registerButton.getClientId(context), message);
            }
    }

    public void setRegisterButton(UIComponent registerButton) {
        this.registerButton = registerButton;
    }

    public UIComponent getRegisterButton() {
        return registerButton;
    }
    
    
}
