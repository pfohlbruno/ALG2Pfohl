package ui.renderers.jlist;

import ui.models.OfferModel;

import javax.swing.*;
import java.awt.*;

public class OfferRenderer extends CellRendererBase<OfferModel> {
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
    public Component getListCellRendererComponent(JList<? extends OfferModel> list, OfferModel offer, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, offer, index, isSelected, cellHasFocus);

        // Název
        setHeading(offer.getName());

        // Cena
        this.lblPrice.setText(createLabelString("Cena", offer.getPrice()));

        // Období
        this.lblDate.setText(createLabelString("Období", offer.getPeriod()));

        // Stravování
        this.lblServiceType.setText(createLabelString("Stravování", offer.getServiceType().getName()));

        // Doprava
        this.lblTransportType.setText(createLabelString("Doprava", offer.getTransportType().getName()));

        // Počet volných míst
        this.lblAvailableCapacity.setText(createLabelString("Volných míst", offer.getAvailableCapacity()));

        // Pokud není dostatek volných míst pro vytvoření rezervace, zobrazím kapacitu červeně.
        if (offer.getAvailableCapacity() > 0) {
            this.lblAvailableCapacity.setForeground(Color.black);
        }
        else {
            this.lblAvailableCapacity.setForeground(Color.red);
        }
        return this;
    }
}