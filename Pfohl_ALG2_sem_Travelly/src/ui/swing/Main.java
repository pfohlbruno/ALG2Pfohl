package ui.swing;

import app.data.providers.HotelProvider;
import app.data.providers.OfferProvider;
import app.entities.Hotel;
import app.entities.Offer;
import ui.models.AppModel;
import ui.models.BookingModel;
import ui.models.OfferModel;
import ui.renderers.jcombobox.OrderItemListCellRenderer;
import ui.renderers.jlist.BookingRenderer;
import ui.renderers.jlist.HotelRenderer;
import ui.renderers.jlist.OfferRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main extends JFrame{
    // Rozměry okna.
    private final int width = 960;
    private final int height = 600;

    private JTabbedPane pnlMain;
    private JPanel pnlOffers;
    private JPanel pnlBookings;
    private JPanel pnlHotels;
    private JList lbHotels;
    private JList lbOffers;
    private JList lbBookings;
    private JComboBox cbHotelsOrder;
    private JComboBox cbOffersOrder;
    private JButton btnBook;
    private JButton btnCancelBooking;

    private AppModel appModel;

    public Main() {
        super("Travelly");
        this.setContentPane(this.pnlMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Nastavení rozměrů okna.
        setPreferredSize(new Dimension(this.width, this.height));
        setResizable(false);


        // Nastavení buňky hotelu.
        this.lbHotels.setFixedCellHeight(100);

        // Nastavení výšky buňky nabídky zájezdu.
        this.lbOffers.setFixedCellHeight(250);

        // Nastavení výšky buňky rezervace.
        this.lbBookings.setFixedCellHeight(250);

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

        // Řazení hotelů.
        this.cbHotelsOrder.setModel(this.appModel.getHotelOrderingItems());
        this.cbHotelsOrder.setRenderer(new OrderItemListCellRenderer());
        this.cbHotelsOrder.addActionListener (e -> this.appModel.refreshData());

        // Řazení nabídek zájezdů.
        this.cbOffersOrder.setModel(this.appModel.getOfferOrderingItems());
        this.cbOffersOrder.setRenderer(new OrderItemListCellRenderer());
        this.cbOffersOrder.addActionListener (e -> this.appModel.refreshData());

        // Tlačítko "Rezervovat" (Rezervuje aktuálně zvolenou nabídku v JListu)
        ActionListener createBookingListener = e -> {
            try {
                OfferModel offer;

                if ((offer = (OfferModel)this.lbOffers.getSelectedValue()) == null) {
                    throw new Exception("Zvolte prosím položku ze seznamu.");
                }

                this.appModel.createBooking(offer);

                showMessageDialog("Rezervace byla vytvořena.");
            } catch (Exception ex) {
                showMessageDialog(ex.getMessage());
            }
        };

        this.btnBook.addActionListener(createBookingListener);

        // Tlačítko "Zrušit rezervaci" (Zruší aktuálně zvolenou rezervaci v JListu)
        ActionListener cancelBookingListener = e -> {
            try {
                BookingModel booking;

                if ((booking = (BookingModel) this.lbBookings.getSelectedValue()) == null) {
                    throw new Exception("Zvolte prosím položku ze seznamu.");
                }

                this.appModel.cancelBooking(booking);
                showMessageDialog("Rezervace byla zrušena.");
            } catch (Exception ex) {
                showMessageDialog(ex.getMessage());
            }
        };

        this.btnCancelBooking.addActionListener(cancelBookingListener);

        this.pack();
    }

    public static void main(String[] args) {
        // Vytvořím instanci okna.
        Main main = new Main();
        // Zviditelním okno.
        main.setVisible(true);
    }

    /**
     * Zobrazí dialog s textem předaným v parametru.
     * @param text Text, který se má v dialogu zobrazit.
     */
    private void showMessageDialog(String text) {
        JOptionPane.showMessageDialog(this, text);
    }
}