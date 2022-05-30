/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managedBeans;

import de.hsh.steam.entities.Genre;
import de.hsh.steam.entities.Rating;
import de.hsh.steam.entities.Score;
import de.hsh.steam.entities.Series;
import de.hsh.steam.entities.Streamingprovider;
import de.hsh.steam.entities.User;
import de.hsh.steam.repositories.SerializedSeriesRepository;
import de.hsh.steam.services.SteamService;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Named;

/**
 *
 * @author marvinpieper
 */
@Named(value = "searchBean")
@SessionScoped
public class SearchBean implements Serializable{
    
    // get the username of the User whitch is logged in 
    //@ManagedProperty("#{loginBean}")
    //private LoginBean loginBean;
    
    // private User user = SerializedSeriesRepository.getInstance().getUserObject(loginBean.getUsername());
    private String username;
    private Genre genre;
    private Streamingprovider streamingProvider;
    private Score score;
    private ArrayList<Series> result;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Streamingprovider getStreamingProvider() {
        return streamingProvider;
    }

    public void setStreamingProvider(Streamingprovider streamingProvider) {
        this.streamingProvider = streamingProvider;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public ArrayList<Series> getResult() {
        return result;
    }

    public void setResult(ArrayList<Series> result) {
        this.result = result;
    }

    
    
    public String searchSerie(String username){
        Series serie = new Series("Lucas Film", 3, Genre.Action, Streamingprovider.Netflix);
        SerializedSeriesRepository.getInstance().addOrModifySeries(serie);
        User u = SerializedSeriesRepository.getInstance().getUserObject(username);
        serie.putOnWatchListOfUser(u);
        Rating r = new Rating(Score.bad, "Toll", u, serie);
        // fill arrayList with the search Results
        result = SerializedSeriesRepository.getInstance().searchSeries(username, genre, streamingProvider, score);
       
        if(!result.isEmpty()){
            return "searchResult";
        } else {
            return "home";
        }
    }
}
