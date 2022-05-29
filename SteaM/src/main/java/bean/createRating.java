package bean;

import de.hsh.steam.entities.Rating;
import de.hsh.steam.entities.Series;
import de.hsh.steam.entities.User;
import de.hsh.steam.repositories.SerializedSeriesRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;

@Named(value= "createRating")
@RequestScoped
public class createRating {
    private String RatingText;

    public void getRating() {

    }
}
