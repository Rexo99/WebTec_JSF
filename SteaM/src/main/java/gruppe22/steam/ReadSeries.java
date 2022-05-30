/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gruppe22.steam;

import de.hsh.steam.entities.Rating;
import de.hsh.steam.entities.Series;
import de.hsh.steam.entities.User;
import de.hsh.steam.repositories.SerializedSeriesRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luca
 */
public class ReadSeries {
    public static List<Rating> getRatings(String username){
        List<Rating> ratings = new ArrayList<>();
        List<Series> serien = SerializedSeriesRepository.getInstance().getAllSeriesOfUser(username);
        User user = SerializedSeriesRepository.getInstance().getUserObject(username);
        for (Series s: serien){
            Rating r = user.ratingOf(s);
            if (r != null){
                ratings.add(r);
            }
        }
        return ratings;
    }  
}
