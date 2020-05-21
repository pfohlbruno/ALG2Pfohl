package ui.swing;

import app.data.providers.HotelProvider;
import app.data.providers.OfferProvider;
import app.entities.Hotel;
import app.entities.Offer;
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

    private List<Hotel> hotels;
    private List<Offer> offers;
    private DefaultListModel<Hotel> listHotelsModel;
    private DefaultListModel<Offer> listOffersModel;

    public Main() {
        super("Travelly");
        this.setContentPane(this.pnlMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(this.width, this.height);

        this.lbHotels.setFixedCellHeight(100);

        try {
            HotelProvider hotelProvider = new HotelProvider();
            this.hotels = hotelProvider.getAll();
            listHotelsModel = new DefaultListModel<>();

            for (Hotel hotel : this.hotels) {
                listHotelsModel.addElement(hotel);
            }

            this.lbHotels.setModel(listHotelsModel);
            this.lbHotels.setCellRenderer(new HotelRenderer());

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Nabídky zájezdů ...

        this.lbOffers.setFixedCellHeight(150);

        this.pack();

        try {
            OfferProvider offerProvider = new OfferProvider();
            this.offers = offerProvider.getAll();
            this.listOffersModel = new DefaultListModel<>();

            for (Offer offer : this.offers) {
                this.listOffersModel.addElement(offer);
            }

            this.lbOffers.setModel(this.listOffersModel);
            this.lbOffers.setCellRenderer(new OfferRenderer());

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.pack();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
    }
}