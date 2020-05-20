package app.entities;
import app.dataprovider.OfferProvider;
import com.opencsv.bean.CsvBindByName;

import java.util.List;

/**
 * Třída reprezentující hotel pro ubytování.
 * @author Bruno Pfohl
 */
public class Hotel extends EntityBase {
    @CsvBindByName
    private String name;
    @CsvBindByName
    private String place;
    @CsvBindByName
    private String imgPath;
    @CsvBindByName
    private int stars;

    @Override
    public String toString() {
        return  String.format(
                "Název: %s \nLokace: %s \nObrázek: %s \nPočet hvězdiček: %s \n",
                this.name,
                this.place,
                this.imgPath,
                this.stars
        );
    }

    /**
     * Prázdný konstruktor pro CSV binder.
     */
    public Hotel() {

    }

    public Hotel(String id, String name, String place, String imgPath, int stars) {
        super(id);
        this.name = name;
        this.place = place;
        this.imgPath = imgPath;
        this.stars = stars;
    }

    /**
     * Vrací název hotelu.
     */
    public String getName() {
        return name;
    }

    /**
     * Vrací místo, kde se hotel nachází.
     */
    public String getPlace() {
        return place;
    }

    /**
     * Vrací cestu k obrázku hotelu.
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * Vrací počet hvězdiček hotelu.
     */
    public int getStars() {
        return stars;
    }

    public List<Offer> getOffers(OfferProvider offerProvider) {
        return offerProvider.getOffersForHotelId(this.id);
    }
}
