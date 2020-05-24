package ui.models;

import app.data.DataProvider;
import app.entities.Booking;
import app.entities.Hotel;
import app.entities.Offer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hlavní model swing ui. Uchovává v sobě veškerá data a logiku aplikace.
 * @author Bruno Pfohl
 */
public class AppModel {
    private DataProvider provider;
    private DefaultListModel<HotelModel> hotels = new DefaultListModel<>();
    private DefaultListModel<OfferModel> offers = new DefaultListModel<>();
    private DefaultListModel<BookingModel> bookings = new DefaultListModel<>();

    public AppModel() throws IOException {
        this.provider = DataProvider.getInstance();
        refreshData();
    }

    /**
     * Refreshne data tohoto modelu (s ohledem na filtry a řazení).
     */
    public void refreshData() {
        // Hotely
        List<Hotel> hotels = this.provider.getHotelProvider().getAll();
        this.hotels.removeAllElements();
        hotels.forEach(h -> this.hotels.addElement(HotelModel.getFromEntity(h)));

        // Nabídky
        List<Offer> offers = provider.getOfferProvider().getAll();
        this.offers.removeAllElements();
        offers.forEach(o -> this.offers.addElement(OfferModel.getFromEntity(o, this.provider)));

        // Rezervace
        List<Booking> bookings  = provider.getBookingProvider().getAll();
        this.bookings.removeAllElements();
        bookings.forEach(b -> this.bookings.addElement(BookingModel.getFromEntity(b, this.provider)));
    }

    public DefaultListModel<HotelModel> getHotels() {
        return this.hotels;
    }

    public DefaultListModel<OfferModel> getOffers() {
        return this.offers;
    }

    public DefaultListModel<BookingModel> getBookings() {
        return this.bookings;
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