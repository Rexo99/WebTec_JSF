package bean;

import de.hsh.steam.entities.Score;
import de.hsh.steam.entities.Series;
import de.hsh.steam.entities.User;
import de.hsh.steam.repositories.SerializedSeriesRepository;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named(value= "createRatingBean")
@SessionScoped
public class createRatingBean implements Serializable {
    private Series series;

    private Score score;

    private String remark;

    public Score getScore() {
        return score;
    }
    public void setScore(Score score) {
        this.score = score;
    }
    public Series getSeries() {
        return series;
    }


    public String getRemark() {
        return remark;
    }

    public void setSeries(Series series) {
        this.series = series;
    }


    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String setRating(Series s) {
        series = s;
        return "rating";
    }

    public String createRating(String username) {
        User user = SerializedSeriesRepository.getInstance().getUserObject(username);
        user.rate(series,score,remark);
        SerializedSeriesRepository.getInstance().saveData();
        return "home";
    }
}
