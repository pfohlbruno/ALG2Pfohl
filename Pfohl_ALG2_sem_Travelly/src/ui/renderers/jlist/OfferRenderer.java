package ui.renderers.jlist;

import app.entities.Hotel;
import app.entities.Offer;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class OfferRenderer extends JPanel implements ListCellRenderer<Offer> {
    private JLabel lblName = new JLabel();
    private JLabel lblPrice = new JLabel();
    private JLabel lblDate = new JLabel();
    private JLabel lblTransportType = new JLabel();
    private JLabel lblServiceType = new JLabel();
    private JLabel lblAvailableCapacity = new JLabel();

    public OfferRenderer() {
        setLayout(new BorderLayout(5, 5));

        JPanel panelText = new JPanel(new GridLayout(0, 1));
        panelText.add(this.lblName);
        panelText.add(this.lblPrice);
        panelText.add(this.lblDate);
        panelText.add(this.lblTransportType);
        panelText.add(this.lblServiceType);
        panelText.add(this.lblAvailableCapacity);
        add(panelText, BorderLayout.CENTER);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Offer> list, Offer offer, int index, boolean isSelected, boolean cellHasFocus) {
        // Název
        this.lblName.setText("Nabídka");
        this.lblName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));

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

        // set Opaque to change background color of JLabel
        this.lblName.setOpaque(true);


        // Pokud je položka zvolená, zvýrazním ji.
        if (isSelected) {
            this.lblName.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
        } else {
            this.lblName.setBackground(list.getBackground());
            setBackground(list.getBackground());
        }

        return this;
    }
}