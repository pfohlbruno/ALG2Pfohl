package ui.renderers.jlist;

import app.entities.Hotel;

import javax.swing.*;
import java.awt.*;

public class HotelRenderer extends JPanel implements ListCellRenderer<Hotel> {
    private JLabel lblIcon = new JLabel();
    private JLabel lblName = new JLabel();
    private JLabel lblStars = new JLabel();

    public HotelRenderer() {
        setLayout(new BorderLayout(5, 5));

        JPanel panelText = new JPanel(new GridLayout(0, 1));
        panelText.add(this.lblName);
        panelText.add(this.lblStars);
        add(lblIcon, BorderLayout.WEST);
        add(panelText, BorderLayout.CENTER);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Hotel> list,  Hotel hotel, int index, boolean isSelected, boolean cellHasFocus) {
        // Obrázek hotelu.

        ImageIcon icon = new ImageIcon(new ImageIcon(hotel.getImgPath()).getImage().getScaledInstance(-1, list.getFixedCellHeight(), Image.SCALE_DEFAULT));

        this.lblIcon.setIcon(icon);

        // Název hotelu.
        this.lblName.setText(hotel.getName());
        this.lblName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));

        // Hodnocení hotelu.
        this.lblStars.setText("Hvězdy: " +  hotel.getStars());
        this.setForeground(Color.decode("#d4af37"));

        // set Opaque to change background color of JLabel
        this.lblName.setOpaque(true);
        this.lblStars.setOpaque(true);
        this.lblIcon.setOpaque(true);

        // Pokud je položka zvolená, zvýrazním ji.
        if (isSelected) {
            this.lblName.setBackground(list.getSelectionBackground());
            this.lblStars.setBackground(list.getSelectionBackground());
            this.lblIcon.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
        } else {
            this.lblName.setBackground(list.getBackground());
            this.lblStars.setBackground(list.getBackground());
            this.lblIcon.setBackground(list.getBackground());
            setBackground(list.getBackground());
        }

        return this;
    }
}