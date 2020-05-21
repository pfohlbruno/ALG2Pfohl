package app.data;

import app.data.providers.BookingProvider;
import app.data.providers.HotelProvider;
import app.data.providers.OfferProvider;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;

/**
 * Třída poskytující přístup ke všem datům (Obal všech providerů).
 * @author Bruno Pfohl
 */
public class DataProvider {
    private BookingProvider bookingProvider;
    private HotelProvider hotelProvider ;
    private OfferProvider offerProvider;

    /**
     * Inicializuje objekt. Vytvoří všechny providery a uloží si je do privátních proměnných.
     * @throws IOException
     */
    private void init() throws IOException {
        // TODO: šlo by udělat kolekci providerů a do té jednotlivé providery registrovat.
        //  Pak by se získávaly z kolekce podle typu objektu.
        this.bookingProvider = new BookingProvider();
        this.hotelProvider = new HotelProvider();
        this.offerProvider = new OfferProvider();
    }

    public BookingProvider getBookingProvider() {
        return bookingProvider;
    }

    public HotelProvider getHotelProvider() {
        return hotelProvider;
    }

    public OfferProvider getOfferProvider() {
        return offerProvider;
    }

    /**
     * Uloží veškerá data do souborů (POZOR! přepíše všechny soubory).
     */
    public void saveAll () throws CsvRequiredFieldEmptyException, IOException, CsvDataTypeMismatchException {
        this.bookingProvider.save();
        this.hotelProvider.save();
        this.offerProvider.save();
    }

    /**
     * Pokusí se vytvořit novou instance poskytovatele dat.
     * @return Instance poskytovatele dat.
     * @throws IOException Chyba, pokud se nepodaří načíst některý ze souborů.
     */
    public static DataProvider getInstance() throws IOException {
        DataProvider instance = new DataProvider();
        instance.init();
        return instance;
    }
}