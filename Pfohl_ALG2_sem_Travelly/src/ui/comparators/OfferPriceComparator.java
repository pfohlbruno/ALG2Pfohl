package ui.comparators;

import app.entities.Offer;
import ui.models.OfferModel;

import java.util.Comparator;

/**
 * Komparátor ceny nabídek.
 * @author Bruno Pfohl
 */
public class OfferPriceComparator implements Comparator<OfferModel> {
    @Override
    public int compare(OfferModel o1, OfferModel o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
