package ui.models;

import java.util.Comparator;

/**
 * Třída reprezentující položku comboboxu (pro řazení záznamů).
 * @author Bruno Pfohl
 */
public class ComboOrderItem {
    private String title;
    private Comparator comparator;

    public ComboOrderItem(String title, Comparator comparator) {
        this.title = title;
        this.comparator = comparator;
    }

    /**
     * Vrací titulek položky (text, který se zobrazí v comboboxu).
     * @return Titulek položky
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Vrací instanci komparátoru, podle kterého se budou položky řadit.
     * @return Instance komparátoru pro řazení položek.
     */
    public Comparator getComparator() {
        return this.comparator;
    }
}
