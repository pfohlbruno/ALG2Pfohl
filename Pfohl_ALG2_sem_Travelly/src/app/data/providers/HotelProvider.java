package app.data.providers;

import ui.comparators.HotelStarsComparator;
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
        return "data\\hotels.csv";
    }
}
