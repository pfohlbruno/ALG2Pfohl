package app.data.providers;

import app.entities.Offer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Třída poskytující data o nabídkách zájezdů (z csv souboru).
 * @author Bruno Pfohl
 */
public class OfferProvider extends ProviderBase<Offer>{
    public OfferProvider() throws IOException {
        super(Offer.class);
    }

    @Override
    public String getSourcePath() {
        return "C:\\Users\\lenovo\\Documents\\GitHub\\ALG2Pfohl\\Pfohl_ALG2_sem_Travelly\\data\\offers.csv";
    }

    /**
     * Vrací záznam se specifikovaným identifikačním klíčem.
     * @param id Unikátní identifikační klíč objektu, který se má mezi daty vyhledat.
     * @return Objekt se specifikovaným id.
     */
    public List<Offer> getOffersForHotelId(String id) {
        return this.data
                .stream()
                .filter(o -> o.getHotelId().equals(id))
                .collect(Collectors
                .toCollection(ArrayList::new));
    }
}