/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package bean;

import de.hsh.steam.entities.Rating;
import de.hsh.steam.repositories.SerializedSeriesRepository;
import gruppe22.steam.ReadSeries;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.util.ArrayList;
import de.hsh.steam.entities.Series;
/**
 *
 * @author luca
 */
@Named(value="showSerienBean")
@SessionScoped
public class ShowSerienBean implements Serializable{
    
    public ArrayList<Series> getAllSeries(String username){
        return SerializedSeriesRepository.getInstance().getAllSeriesOfUser(username);
    }
    
   
}
