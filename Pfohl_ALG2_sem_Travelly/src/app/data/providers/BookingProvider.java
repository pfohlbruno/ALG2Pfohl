package app.data.providers;

import app.data.DataProvider;
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
    public void create(Offer offer, int personCount) throws Exception {
        // Zkontroluju, jestli je dostatek volných míst pro všechny osoby.
        if (offer.getAvailableCapacity() >= personCount) {
            // Vytvořím objekt rezervace.
            Booking booking = new Booking(offer.getId(), personCount);
            offer.useCapacity(personCount);
            this.data.add(booking);
        }
        else {
            // Není dostatek místa pro všechny osoby. Vracím false.
            throw new Exception("Nelze se zarezervovat! Nedostatek místa.");
        }
    }

    /**
     * Zruší rezervaci nabídky dovolené.
     * @param booking instance rezervace, která se má zrušit
     * @param provider instance data provideru pro získání potřebných dat
     * @throws Exception Chyba, pokud se nepodaří uvolnit místa nebo zájezd nebyl dohledán.
     */
    public void cancel(Booking booking, DataProvider provider) throws Exception {
        Offer offer = provider.getOfferProvider().getById(booking.getOfferId());

        if (offer == null)
            throw new Exception("Nepodařilo se dohledat nabídku zájezdu.");

        // Uvolním místa u nabídky.
        offer.freeCapacity(booking.getPersonCount());

        // Odstraním rezervaci.
        this.data.remove(booking);
    }

    @Override
    public String getSourcePath() {
        return "C:\\Users\\lenovo\\Documents\\GitHub\\ALG2Pfohl\\Pfohl_ALG2_sem_Travelly\\data\\bookings.csv";
    }
}
