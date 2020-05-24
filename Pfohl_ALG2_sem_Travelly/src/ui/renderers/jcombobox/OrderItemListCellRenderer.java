package ui.renderers.jcombobox;

import ui.models.ComboOrderItem;

import javax.swing.*;
import java.awt.*;

/**
 * Renderer OrderItem položky comboboxu.
 * @author Bruno Pfohl
 */
public class OrderItemListCellRenderer extends JLabel implements ListCellRenderer<ComboOrderItem> {
    @Override
    public Component getListCellRendererComponent(JList<? extends ComboOrderItem> list, ComboOrderItem value, int index, boolean isSelected, boolean cellHasFocus) {
        // Nastavím text položky.
        this.setText(value.getTitle());
        return this;
    }
}