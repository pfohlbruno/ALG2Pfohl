package app.dataprovider;

import app.entities.Booking;
import app.entities.Offer;

import java.io.IOException;

/**
 * Třída poskytující data o rezervacích (z csv souboru).
 * @author Bruno Pfohl
 */
public class BookingProvider extends ProviderBase<Booking>{
    public BookingProvider() throws IOException {
        super(Booking.class);
    }

    /**
     * Vytvoří rezervaci nabídky dovolené.
     * @param offer instance nabídky dovolené
     * @param personCount počet osob, které se si nabídku rezervují
     * @return True nebo false dle toho, jestli je možné pro aktuální parametry vytvořit rezervaci.
     */
    public boolean create(Offer offer, int personCount) throws Exception {
        // Zkontroluju, jestli je dostatek volných míst pro všechny osoby.
        if (offer.getAvailableCapacity() > personCount) {
            // Vytvořím objekt rezervace.
            Booking booking = new Booking(offer.getId(), personCount);
            offer.useCapacity(personCount);
            this.data.add(booking);
            return true;
        }

        // Není dostatek místa pro všechny osoby. Vracím false.
        return false;
    }

    @Override
    public String getSourcePath() {
        return "bookings.csv";
    }
}
