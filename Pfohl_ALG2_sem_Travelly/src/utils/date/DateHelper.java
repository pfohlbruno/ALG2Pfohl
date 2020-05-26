package utils.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Pomocná kninovna pro práci s datumy a časem.
 * @author Bruno Pfohl
 */
public class DateHelper {
    /**
     * Vrací datum zformátované do krátké textové podoby (dd. MM. YYYY).
     * @param date Datum, které chceme zformátovat.
     */
    public static String getShortDateString(Date date) {
        SimpleDateFormat f = new SimpleDateFormat("dd. MM. yyyy");
        return f.format(date);
    }
}
