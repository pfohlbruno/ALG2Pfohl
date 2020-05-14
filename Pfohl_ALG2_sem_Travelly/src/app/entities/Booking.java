package app.entities;

import com.opencsv.bean.CsvBindByName;

public class Booking extends EntityBase{

    @CsvBindByName
    private String offerId;
    @CsvBindByName
    private int personCount;

    /**
     * Prázdný konstruktor pro CSV binder.
     */
    public Booking() {

    }

    public Booking(String offerId, int personCount) {
        this(Booking.GenerateNewId(), offerId, personCount);
    }

    public Booking(String id, String offerId, int personCount) {
        super(id);
        this.offerId = offerId;
        this.personCount = personCount;
    }

    public String getOfferId() {
        return offerId;
    }

    public int getPersonCount() {
        return personCount;
    }
}
