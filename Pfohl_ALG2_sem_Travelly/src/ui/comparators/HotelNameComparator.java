package ui.comparators;

import ui.models.HotelModel;

import java.util.Comparator;

/**
 * Komparátor pro řazení hotelů podle abecedy.
 */
public class HotelNameComparator implements Comparator<HotelModel> {
    @Override
    public int compare(HotelModel h1, HotelModel h2) {
        return h1.getName().compareTo(h2.getName());
    }
}
