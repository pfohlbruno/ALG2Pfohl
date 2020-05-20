package app.comparators;

import app.entities.Offer;

import java.util.Comparator;

/**
 * Komparátor ceny nabídek.
 * @author Bruno Pfohl
 */
public class OfferPriceComparator implements Comparator<Offer> {
    @Override
    public int compare(Offer o1, Offer o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
