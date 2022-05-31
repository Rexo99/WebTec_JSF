/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package bean;

import de.hsh.steam.entities.Genre;
import de.hsh.steam.entities.Series;
import de.hsh.steam.entities.Streamingprovider;
import de.hsh.steam.repositories.SerializedSeriesRepository;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author luca
 */
@Named(value="createSeries")
@RequestScoped
public class CreateSeriesBean {
    private String title;
    private int numberOfSeasons;
    private Genre genre;
    private Streamingprovider provider;

    public Streamingprovider getProvider() {
        return provider;
    }

    public void setProvider(Streamingprovider provider) {
        this.provider = provider;
    }

    
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    
    
    public String createSeries(String username){
        Series serie = new Series(title, numberOfSeasons, genre, provider);
        SerializedSeriesRepository instance = SerializedSeriesRepository.getInstance();
        if (numberOfSeasons == 0 ){
            return "createSeries";
        }
        serie = instance.addOrModifySeries(serie);
        serie.putOnWatchListOfUser(instance.getUserObject(username));
        if(instance.getAllSeries().contains(serie)){
            instance.saveData();
            return "home";
        } else {
            return "createSeries";
        }
    }
}
