package ui.models;

import app.data.DataProvider;
import app.entities.Hotel;
import app.entities.Offer;
import app.enums.ServiceTypeEnum;
import app.enums.TransportTypeEnum;
import utils.date.DateHelper;

/**
 * Model nabídky zájezdu určený pro zobrazování dat v UI.
 * @author Bruno Pfohl
 */
public class OfferModel {
    private String id;
    private String name;
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
        this.id = offer.getId();
        this.name = offer.getName();
        this.hotelId = offer.getHotelId();
        this.price = offer.getPrice();
        this.transportType = offer.getTransportType();
        this.serviceType = offer.getServiceType();
        this.availableCapacity = offer.getAvailableCapacity();
        this.period = DateHelper.getShortDateString(offer.getFrom()) + " - " + DateHelper.getShortDateString(offer.getTo());
    }

    /**
     * Vrací Id nabídky.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Vrací název nabídky zájezdu.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Vrací cenu nabídky zájezdu.
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Vrací druh dopravy.
     */
    public TransportTypeEnum getTransportType() {
        return this.transportType;
    }

    /**
     * Vrací typ stravování (plná penze, polopenze, ...).
     */
    public ServiceTypeEnum getServiceType() {
        return this.serviceType;
    }

    /**
     * Vrací počet dostupných míst, které lze ještě zarezervovat.
     */
    public int getAvailableCapacity() {
        return this.availableCapacity;
    }

    /**
     * Vrací název hotelu.
     */
    public String getHotelName() {
        return this.hotelName;
    }

    /**
     * Vrací období, kdy se má konat zájezd.
     */
    public String getPeriod() {
        return this.period;
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
