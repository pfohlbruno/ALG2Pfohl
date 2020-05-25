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
    private String offerName;
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

    /**
     * Vrací id hotelu.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Vrací počet rezervovaných osob.
     */
    public int getPersonCount() {
        return this.personCount;
    }

    /**
     * Vrací cenu rezervace.
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Vrací název hotelu.
     */
    public String getHotelName() {
        return this.hotelName;
    }

    /**
     * Vrací druh stravování na dovolené (zformátovaný textový řetězec).
     */
    public String getServiceTypeFormatted() {
        return this.serviceTypeFormatted;
    }

    /**
     * Vrací druh dopravy (zformátovaný textový řetězec).
     */
    public String getTransportTypeFormatted() {
        return this.transportTypeFormatted;
    }

    /**
     * Vrací období zájezdu (zformátovaný textový řetězec).
     */
    public String getPeriodFormatted() {
        return this.periodFormatted;
    }

    /**
     * Vrací název zájezdu.
     */
    public String getOfferName() {
        return this.offerName;
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

        instance.offerName = offer.getName();
        instance.price = offer.getPrice();
        instance.hotelName = hotel.getName();
        instance.serviceTypeFormatted = offer.getServiceType().toString();
        instance.transportTypeFormatted = offer.getTransportType().toString();

        return instance;
    }
}