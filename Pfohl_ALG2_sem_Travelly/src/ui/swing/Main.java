package ui.swing;

import app.data.providers.HotelProvider;
import app.data.providers.OfferProvider;
import app.entities.Hotel;
import app.entities.Offer;
import ui.models.AppModel;
import ui.renderers.jlist.BookingRenderer;
import ui.renderers.jlist.HotelRenderer;
import ui.renderers.jlist.OfferRenderer;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class Main extends JFrame{
    // Rozměry okna.
    private int width = 350;
    private int height = 200;

    private JTabbedPane pnlMain;
    private JPanel pnlHotels;
    private JList lbHotels;
    private JList lbOffers;
    private JList lbBookings;
    private JPanel pnlOffers;
    private JPanel pnlBookings;

    private AppModel appModel;

    public Main() {
        super("Travelly");
        this.setContentPane(this.pnlMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Nastavení rozměrů okna.
        setSize(this.width, this.height);

        // Nastavení buňky hotelu.
        this.lbHotels.setFixedCellHeight(100);

        // Nastavení výšky buňky nabídky zájezdu.
        this.lbOffers.setFixedCellHeight(150);

        // Inicializace hlavního modelu.
        try {
            this.appModel = new AppModel();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Inicializace modelu se nezdařila. Důvodem je neúspěšné načtení dat .. " +  e.getMessage());
        }

        // "Binding" kolekce hotelů
        this.lbHotels.setModel(this.appModel.getHotels());
        this.lbHotels.setCellRenderer(new HotelRenderer());

        // "Binding" kolekce nabídek
        this.lbOffers.setModel(this.appModel.getOffers());
        this.lbOffers.setCellRenderer(new OfferRenderer());

        // "Binding" kolekce nabídek
        this.lbBookings.setModel(this.appModel.getBookings());
        this.lbBookings.setCellRenderer(new BookingRenderer());

        this.pack();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
    }
}