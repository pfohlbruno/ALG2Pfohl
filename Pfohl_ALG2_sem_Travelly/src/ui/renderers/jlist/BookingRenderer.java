package ui.renderers.jlist;

import ui.models.BookingModel;

import javax.swing.*;
import java.awt.*;

public class BookingRenderer extends CellRendererBase<BookingModel> {
    /**
     * Název rezervovaného hotelu.
     */
    private JLabel hotelName = new JLabel();

    /**
     * Období rezervace (od kdy do kdy).
     */
    private JLabel period = new JLabel();

    /**
     * Celková cena.
     */
    private JLabel price = new JLabel();

    /**
     * Počet rezervovaných osob.
     */
    private JLabel personCount = new JLabel();

    /**
     * Typ stravování.
     */
    private JLabel serviceType = new JLabel();

    /**
     * Druh dopravy.
     */
    private JLabel transportType = new JLabel();


    /**
     * Konstruktor pro vytvoření instance rendereru buňky s rezervací.
     */
    public BookingRenderer() {
        addTextPanelItem(this.hotelName);
        addTextPanelItem(this.period);
        addTextPanelItem(this.price);
        addTextPanelItem(this.personCount);
        addTextPanelItem(this.serviceType);
        addTextPanelItem(this.transportType);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends BookingModel> list, BookingModel booking, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, booking, index, isSelected, cellHasFocus);

        // Nadpis buňky (název nabídky zájezdu).
        setHeading(booking.getOfferName());

        // Období zájezdu.
        this.period.setText("Období: " + booking.getPeriodFormatted());

        // Cena rezervace.
        this.price.setText("Cena: " + booking.getPrice());

        // Počet zarezervovaných osob.
        this.personCount.setText("Počet osob: " + booking.getPersonCount());

        // Druh stravování.
        this.serviceType.setText("Stravování: " + booking.getServiceTypeFormatted());

        // Druh dopravy.
        this.transportType.setText("Doprava: " + booking.getTransportTypeFormatted());

        return this;
    }
}