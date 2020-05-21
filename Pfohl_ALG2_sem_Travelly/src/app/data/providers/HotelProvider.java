package app.data.providers;

import app.comparators.HotelStarsComparator;
import app.entities.Hotel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Třída poskytující data o hotelech (z csv souboru).
 * @author Bruno Pfohl
 */
public class HotelProvider extends ProviderBase<Hotel>{
    public HotelProvider() throws IOException {
        super(Hotel.class);
    }

    @Override
    public String getSourcePath() {
        return "C:\\Users\\lenovo\\Documents\\GitHub\\ALG2Pfohl\\Pfohl_ALG2_sem_Travelly\\data\\hotels.csv";
    }

    public List<Hotel> withMoreStarsThan(int stars) {
        return this.data
                .stream()
                .filter(o -> o.getStars() > stars)
                .collect(Collectors
                    .toCollection(ArrayList::new)
                );
    }

    public static void sortByStars(List<Hotel> hotels) {
        hotels.sort(new HotelStarsComparator());
    }

    public static void sortByPriceDesc(List<Hotel> hotels) {
        hotels.sort(new HotelStarsComparator().reversed());
    }
}
