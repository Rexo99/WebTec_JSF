package bean;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import de.hsh.steam.main.SteamTest;
import de.hsh.steam.repositories.SerializedSeriesRepository;
import de.hsh.steam.services.SteamService;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
/**
 *
 * @author dunkel
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        //SteamTest.initData();
    }
    
    String username;
    String pwd;
    String result;
    UIComponent loginButton; 


    public String getUsername() {
        System.out.println("Getter user: "+ this.username + "   obj: "+ this);
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        System.out.println("Setter user: "+ this.username + "   obj: "+ this);
    }

    public String getPwd() {
        System.out.println("Getter pwd: "+ this.pwd + "   obj: "+ this);
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
        System.out.println("setter pwd: "+ this.pwd + "   obj: "+ this);
    }
    
    public String login(){
        boolean valid = SteamService.getInstance().login(this.username, this.pwd);
        if (valid){
            SerializedSeriesRepository.getInstance().readData();
            return "home";
        }
        else {
            FacesMessage message = new FacesMessage("Wrong Password");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(loginButton.getClientId(context), message);
        }
        return null;
    }
    

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public UIComponent getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(UIComponent loginButton) {
        this.loginButton = loginButton;
    }
    
}
