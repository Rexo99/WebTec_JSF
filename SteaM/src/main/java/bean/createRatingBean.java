package bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value= "createRatingBean")
@RequestScoped
public class createRatingBean {
    private String ratingText;

    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }

    public void getRating() {

    }
}
