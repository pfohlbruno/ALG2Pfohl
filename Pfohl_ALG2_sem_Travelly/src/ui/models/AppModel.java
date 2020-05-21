package ui.models;

import app.data.DataProvider;
import app.entities.Booking;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Hlavní model swing ui. Uchovává v sobě veškerá data a logiku aplikace.
 * @author Bruno Pfohl
 */
public class AppModel {
    private DataProvider provider = new DataProvider();

    List<HotelModel> hotels = new ArrayList<>();
    List<OfferModel> offers = new ArrayList<>();
    List<BookingModel> bookings = new ArrayList<>();

    /**
     * Refreshne data tohoto modelu (s ohledem na filtry a řazení).
     */
    public void refreshData() {
        // this.hotels = provider.getHotelProvider().getAll();
    }

    /**
     * Pokusí se vytvořit rezervaci na zvolenou nabídku.
     * @param offer Nabídka, která se má zarezervovat
     */
    public void createBooking(OfferModel offer) {
        throw new NotImplementedException();
    }

    /**
     * Zruší zvolenou rezervaci.
     * @param booking Rezervace, která se má zrušit.
     */
    public void removeBooking(Booking booking) {
        throw new NotImplementedException();
    }

    /**
     * Uloží aktuální stav aplikace do CSV souborů (POZOR! komplet vše přepíše).
     */
    private void saveChanges() {
        throw new NotImplementedException();
    }
}