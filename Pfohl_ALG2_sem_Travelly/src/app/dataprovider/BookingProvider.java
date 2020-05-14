package app.dataprovider;

import app.entities.Booking;
import app.entities.Offer;

import java.io.IOException;

public class BookingProvider extends ProviderBase<Booking>{
    public BookingProvider() throws IOException {
        super(Booking.class);
    }

    public boolean create(Offer offer, int personCount) {
        if (offer.availableCapacity() > personCount) {
            Booking booking = new Booking(offer.getId(), personCount);
            offer.setUsedCapacity(offer.getUsedCapacity() + personCount);
            this.data.add(booking);
            return true;
        }

        return false;
    }

    @Override
    public String getSourcePath() {
        return "bookings.csv";
    }
}
