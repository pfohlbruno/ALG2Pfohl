package ui.models;

import app.data.DataProvider;
import app.entities.Hotel;
import app.entities.Offer;
import app.enums.ServiceTypeEnum;
import app.enums.TransportTypeEnum;

/**
 * Model nabídky zájezdu určený pro zobrazování dat v UI.
 * @author Bruno Pfohl
 */
public class OfferModel {
    private String hotelId;
    private int price;

    private TransportTypeEnum transportType;
    private ServiceTypeEnum serviceType;
    private int availableCapacity;
    private String hotelName;
    private String period;

    /**
     * Privátní konstruktor, který vrácí instanci objektu vytvořenou z entity.
     * @param offer Entita nabídky zájezdu, ze které se má vytvořit model.
     */
    private OfferModel(Offer offer) {
        this.hotelId = offer.getHotelId();
        this.price = offer.getPrice();
        this.transportType = offer.getTransportType();
        this.serviceType = offer.getServiceType();
        this.availableCapacity = offer.getAvailableCapacity();
        this.period = "čas";
    }

    public int getPrice() {
        return price;
    }

    public TransportTypeEnum getTransportType() {
        return transportType;
    }

    public ServiceTypeEnum getServiceType() {
        return serviceType;
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getPeriod() {
        return period;
    }

    /**
     * Vrací model nabídky zájezdu vytvořený z entiy.
     * @param offer Entita, ze které se má model vytvořit.
     * @param provider DataProvider pro získání dodatečných dat.
     * @return Model nabídky zájezdu
     */
    public static OfferModel getFromEntity(Offer offer, DataProvider provider) {
        // Vytvořím si novou instanci modelu.
        OfferModel instance = new OfferModel(offer);

        // Vytáhnu si entity hotelu pro doplnění dodatečných informací do modelu.
        Hotel hotel = provider.getHotelProvider().getById(offer.getHotelId());

        instance.hotelName = hotel.getName();

        return instance;
    }
}
