package app.dataprovider;

import app.entities.Offer;

import java.io.IOException;

public class OfferProvider extends ProviderBase<Offer>{
    public OfferProvider() throws IOException {
        super(Offer.class);
    }

    @Override
    public String getSourcePath() {
        return "offers.csv";
    }
}