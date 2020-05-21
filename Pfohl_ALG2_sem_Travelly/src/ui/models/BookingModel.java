package ui.models;

import app.data.DataProvider;
import app.entities.Booking;
import app.entities.Hotel;
import app.entities.Offer;

/**
 * Model rezervace určený pro zobrazování dat v UI.
 * @author Bruno Pfohl
 */
public class BookingModel {
    private String id;
    private int personCount;
    private int price;
    private String hotelName;
    private String serviceTypeFormatted;
    private String transportTypeFormatted;
    private String periodFormatted;

    /**
     * Privátní konstruktor, který vrácí instanci objektu vytvořenou z entity.
     * @param booking Entita rezervace, ze které se má vytvořit model.
     */
    private BookingModel(Booking booking) {
        this.id = booking.getId();
        this.personCount = booking.getPersonCount();
    }

    public int getPersonCount() {
        return personCount;
    }

    public int getPrice() {
        return price;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getServiceTypeFormatted() {
        return serviceTypeFormatted;
    }

    public String getTransportTypeFormatted() {
        return transportTypeFormatted;
    }

    public String getPeriodFormatted() {
        return periodFormatted;
    }

    /**
     * Vrací instanci modelu rezervace vytvořenou z entity.
     * @param booking Entita rezervace
     * @param provider DataProvider pro získání dotatečných informací ohledně rezervace.
     * @return Model rezervace
     */
    public static BookingModel getFromEntity(Booking booking, DataProvider provider) {
        // Vytvořím si novou instanci modelu částečně naplněnou daty z entity.
        BookingModel instance = new BookingModel(booking);

        // Vytáhnu si entity nabídky a hotelu, abych z nich mohl doplnit model o další data.
        Offer offer = provider.getOfferProvider().getById(booking.getOfferId());
        Hotel hotel = provider.getHotelProvider().getById(offer.getHotelId());

        instance.price = offer.getPrice();
        instance.hotelName = hotel.getName();
        instance.serviceTypeFormatted = offer.getServiceType().toString();
        instance.transportTypeFormatted = offer.getTransportType().toString();

        return instance;
    }
}