package ui.renderers.jlist;

import app.entities.Hotel;
import ui.models.HotelModel;

import javax.swing.*;
import java.awt.*;

public class HotelRenderer extends CellRendererBase<HotelModel> {
    /**
     * Hodnocení hotelu.
     */
    private JLabel lblStars = new JLabel();

    /**
     * Umístění hotelu.
     */
    private JLabel lblPlace = new JLabel();


    /**
     * Konstruktor pro vytvoření instance rendereru (volá bázový konstruktor a povoluje obrázek).
     */
    public HotelRenderer() {
        super(true);

        addTextPanelItem(this.lblStars);
        addTextPanelItem(this.lblPlace);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends HotelModel> list, HotelModel hotel, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, hotel, index, isSelected, cellHasFocus);

        // Název hotelu.
        setHeading(hotel.getName());

        // Místo pobytu.
        this.lblPlace.setText(hotel.getLocation());

        // Hodnocení hotelu.
        this.lblStars.setText(new String(new char[hotel.getStars()]).replace("\0", "⋆"));
        this.lblStars.setForeground(Color.decode("#d4af37"));

        return this;
    }
}