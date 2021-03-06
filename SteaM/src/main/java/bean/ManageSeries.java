/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package bean;

import de.hsh.steam.entities.Rating;
import de.hsh.steam.entities.Score;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import de.hsh.steam.entities.Series;
import de.hsh.steam.repositories.SerializedSeriesRepository;
import de.hsh.steam.entities.User;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;



/**
 *
 * @author marvinpieper
 */
@SessionScoped
@Named(value = "manageSeries")
public class ManageSeries implements Serializable{

    private Series serie;

    public String edit(Series s){
        setSerie(s);
        return "singelSerie";
    }
    
    public void setSerie(Series serie) {
        this.serie = serie;
    }
    
    public Series getSerie() {
        return serie;
    }
    public String getRemark(Series s, String username) {
        SerializedSeriesRepository instance = SerializedSeriesRepository.getInstance();
        User u = instance.getUserObject(username);
        Rating r = u.ratingOf(s);
        if(r == null){
            return " ";
        }
        return r.getRemark();
    }
    
    public String getRated(Series s, String username){
        SerializedSeriesRepository instance = SerializedSeriesRepository.getInstance();
        User u = instance.getUserObject(username);
        Rating r = u.ratingOf(s);
        if(r == null){
            return " - ";
        }
        return r.getScore().toString();
    }
    public String save(){
        Series new_s = new Series(serie.getTitle(), serie.getNumberOfSeasons(), serie.getGenre(), serie.getStreamedBy());
        SerializedSeriesRepository instance = SerializedSeriesRepository.getInstance();
        serie = instance.addOrModifySeries(new_s);
        instance.saveData();
        
        return "home";
    }
}
