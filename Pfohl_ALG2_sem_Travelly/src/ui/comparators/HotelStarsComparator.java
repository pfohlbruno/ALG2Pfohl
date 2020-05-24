package ui.comparators;

import app.entities.Hotel;
import ui.models.HotelModel;

import java.util.Comparator;

/**
 * Komparátor hodnocení hotelů.
 * @author Bruno Pfohl
 */
public class HotelStarsComparator implements Comparator<HotelModel> {
    @Override
    public int compare(HotelModel h1, HotelModel h2) {
        return h1.getStars() - h2.getStars();
    }
}
