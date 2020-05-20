package app.comparators;

import app.entities.Hotel;

import java.util.Comparator;

/**
 * Komparátor hodnocení hotelů.
 * @author Bruno Pfohl
 */
public class HotelStarsComparator implements Comparator<Hotel> {
    @Override
    public int compare(Hotel h1, Hotel h2) {
        return h1.getStars() - h2.getStars();
    }
}
