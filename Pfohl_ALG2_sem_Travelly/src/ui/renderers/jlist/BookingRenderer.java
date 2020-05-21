package ui.renderers.jlist;

import app.entities.Booking;
import app.entities.Hotel;
import ui.models.BookingModel;

import javax.swing.*;
import java.awt.*;

public class BookingRenderer extends CellRendererBase<BookingModel> {
    /**
     * Konstruktor pro vytvoření instance rendereru buňky s rezervací.
     */
    public BookingRenderer() {
        //addTextPanelItem(this.lblStars);
        //addTextPanelItem(this.lblPlace);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends BookingModel> list, BookingModel booking, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, booking, index, isSelected, cellHasFocus);

        return this;
    }
}