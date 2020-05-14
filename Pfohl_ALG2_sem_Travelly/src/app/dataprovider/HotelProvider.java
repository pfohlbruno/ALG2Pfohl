package app.dataprovider;

import app.entities.Hotel;

import java.io.IOException;

public class HotelProvider extends ProviderBase<Hotel>{
    public HotelProvider() throws IOException {
        super(Hotel.class);
    }

    @Override
    public String getSourcePath() {
        return "C:\\Users\\lenovo\\Documents\\GitHub\\ALG2Pfohl\\Pfohl_ALG2_sem_Travelly\\data\\hotels.csv";
    }
}
