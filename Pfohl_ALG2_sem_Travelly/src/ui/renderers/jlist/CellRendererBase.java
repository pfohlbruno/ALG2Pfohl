package ui.renderers.jlist;

import ui.models.ModelWithImage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * Bázová třída pro renderery JList položek.
 * @param <T> Typ objektu položky.
 * @author Bruno Pfohl
 */
public class CellRendererBase<T> extends JPanel implements ListCellRenderer<T> {
    /**
     * Příznak, jestli se využívá ikonka nebo ne.
     */
    private boolean useIcon;

    /**
     * Label s ikonkou.
     */
    private JLabel lblIcon = new JLabel();


    /**
     * Label s nadpisem buňky.
     */
    private JLabel lblHeading = new JLabel();

    /**
     * Separátor pod nadpisem buňky.
     */
    private JSeparator headingSeparator = new JSeparator();

    /**
     * Panel, který obsahuje veškerý obsah buňky (skládá se z obrázku).
     */
    protected JPanel panelContent = new JPanel(new GridLayout(2, 1));
    protected JPanel panelHeading = new JPanel(new GridLayout(0, 4));
    protected JPanel panelText = new JPanel(new GridLayout(0, 1));

    /**
     * Kolekce textových položek, které se v buňce zobrazují pod sebe.
     */
    private ArrayList<JLabel> panelTextItems = new ArrayList<>();

    /**
     * Konstruktor pro inicializaci rendereru JList položky.
     */
    public CellRendererBase() {
        // Nastavení layoutu buňky.
        setLayout(new BorderLayout(5, 5));
        // Ohraničení buňky.
        this.setBorder(new EmptyBorder(10,10, 10, 10));
        // Do hlavního panelu přidám panel s nadpisem a separátorem.
        this.panelContent.add(this.panelHeading);
        // Nadpis buňky.
        this.lblHeading.setBorder(new EmptyBorder(0, 10, 0, 0));
        this.panelHeading.add(this.lblHeading);

        // Separátor nadpisu a obsahu.
        this.headingSeparator.setSize(-1, 2);
        this.headingSeparator.setForeground(Color.lightGray);
        this.headingSeparator.setOpaque(true);

        // Do hlavního panelu přidám panel s textovými položkami.
        this.panelContent.add(this.panelText);

        add(this.panelContent, BorderLayout.CENTER);
    }

    /**
     * Konstruktor pro inicializaci rendereru JList položky.
     * @param useIcon Specifikuje, jestli se jedná o položku s ikonkou (položky s ikonkou musí být "EntityWithImage").
     */
    public CellRendererBase(boolean useIcon) {
        // Zavolám hlavní konstruktor
        this();

        // Pokud bylo specifikováno, že se má použít ikonka, přidám ji vlevo do buňky.
        this.useIcon = useIcon;
        if (useIcon) {
            add(this.lblIcon, BorderLayout.WEST);
        }
    }

    /**
     * Přidá textový popisek (JLabel) do hlavní části buňky s textem.
     * @param lbl Instance labelu.
     */
    protected void addTextPanelItem(JLabel lbl) {
        this.panelTextItems.add(lbl);
        lbl.setBorder(new EmptyBorder(5, 10, 5, 0));
        panelText.add(lbl);
    }

    /**
     * Nastaví text nadpisu buňky.
     * @param text Text nadpisu buňky.
     */
    protected void setHeading(String text) {
        this.lblHeading.setText(text);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends T> list, T o, int index, boolean isSelected, boolean cellHasFocus) {
        // Nadpis buňky
        this.lblHeading.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));

        // Nastavení ikonky...
        if (this.useIcon) {
            // Přetypuji objekt na "EntityWithImage" a získám z něho cestu k obrázku.
            String imgPath = ((ModelWithImage)o).getImgPath();
            // Vytvořím objekt ikonky.
            ImageIcon icon = new ImageIcon(new ImageIcon(imgPath).getImage().getScaledInstance(-1, list.getFixedCellHeight(), Image.SCALE_DEFAULT));
            // Nastavím ikonku.
            this.lblIcon.setIcon(icon);
        }

        // Zvýrazním položku, pokud je zvolená.
        Color backGround = isSelected ? list.getSelectionBackground() : list.getBackground();
        for (JLabel lbl : this.panelTextItems) {
            lbl.setOpaque(true);
            lbl.setBackground(backGround);
            setBackground(backGround);
        }

        this.lblHeading.setBackground(backGround);
        this.headingSeparator.setBackground(backGround);

        return this;
    }
}