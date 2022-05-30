/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package bean;

import de.hsh.steam.entities.Genre;
import de.hsh.steam.entities.Streamingprovider;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author luca
 */
@Named(value="showSeriesBean")
@RequestScoped
public class CreateSeriesBean {
    private String title;
    private int numbeOfSeasons;
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

    public int getNumbeOfSeasons() {
        return numbeOfSeasons;
    }

    public void setNumbeOfSeasons(int numbeOfSeasons) {
        this.numbeOfSeasons = numbeOfSeasons;
    }
    
    
}
