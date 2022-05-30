/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package bean;

import de.hsh.steam.entities.Rating;
import gruppe22.steam.ReadSeries;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author luca
 */
@Named(value="showSerienBean")
@SessionScoped
public class ShowSerienBean implements Serializable{
    
    public List<Rating> getRatings(String username){
        return ReadSeries.getRatings(username);
    }   
}
