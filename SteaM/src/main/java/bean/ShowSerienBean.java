/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package bean;

import de.hsh.steam.entities.Genre;
import de.hsh.steam.entities.Rating;
import de.hsh.steam.entities.Series;
import de.hsh.steam.entities.User;
import de.hsh.steam.entities.Score;
import de.hsh.steam.entities.Streamingprovider;
import de.hsh.steam.repositories.SerializedSeriesRepository;
import java.io.Serializable;
import java.util.ArrayList;
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
    private List<Rating> ratings = new ArrayList<Rating>();
    
    public ShowSerienBean(){
        User luca = new User("Luca", "123");
        ratings.add(new Rating(Score.good, "spuper", luca, new Series("Title", 10, Genre.Action, Streamingprovider.Netflix)));
        ratings.add(new Rating(Score.bad, "Eine tolle Serie", luca, new Series("Dinotopia", 35, Genre.Action, Streamingprovider.Netflix)));
        ratings.add(new Rating(Score.good, "spuper 2", luca, new Series("Was tue ich hier", 2, Genre.Action, Streamingprovider.Netflix)));
        ratings.add(new Rating(Score.good, "Absoluter Müll", luca, new Series("Serie 4", 4, Genre.Drama, Streamingprovider.Netflix)));
        
        String username;
        
        List<Series> serien = SerializedSeriesRepository.getInstance().getAllSeriesOfUser(username);
        User user = SerializedSeriesRepository.getInstance().getUserObject(username);
        for (Series s: serien){
            Rating r = user.ratingOf(s);
            if (r != null){
                ratings.add(r);
            }
        }
    }
    
    public List<Rating> getRatings(){
        return ratings;
    }
    
    public void setRatings(List<Rating> ratings){
        this.ratings = ratings;
    }
}
