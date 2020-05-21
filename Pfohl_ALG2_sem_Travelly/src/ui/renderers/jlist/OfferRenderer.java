package ui.renderers.jlist;

import app.entities.Offer;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class OfferRenderer extends CellRendererBase<Offer> {
    private JLabel lblPrice = new JLabel();
    private JLabel lblDate = new JLabel();
    private JLabel lblTransportType = new JLabel();
    private JLabel lblServiceType = new JLabel();
    private JLabel lblAvailableCapacity = new JLabel();

    public OfferRenderer() {
        addTextPanelItem(this.lblPrice);
        addTextPanelItem(this.lblDate);
        addTextPanelItem(this.lblTransportType);
        addTextPanelItem(this.lblServiceType);
        addTextPanelItem(this.lblAvailableCapacity);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Offer> list, Offer offer, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, offer, index, isSelected, cellHasFocus);

        // Název
        setHeading("Nabídka");

        // Cena
        this.lblPrice.setText("Cena: " +  offer.getPrice());

        // Období
        SimpleDateFormat f = new SimpleDateFormat("dd. MM. yyyy");
        this.lblDate.setText(String.format("Období: %s - %s", f.format(offer.getFrom()), f.format(offer.getTo())));

        // Stravování
        this.lblServiceType.setText("Stravování: " + offer.getServiceType().toString());

        // Doprava
        this.lblTransportType.setText("Doprava: " + offer.getTransportType().toString());

        // Počet volných míst
        this.lblAvailableCapacity.setText("Počet volných míst: " + offer.getAvailableCapacity());

        return this;
    }
}