package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Třída sloužící pro zapsání textu do souboru.
 * @author Bruno Pfohl
 */
public class TextWriter {
    private static String filePath = "data/log.txt";

    public static void write(LocalDateTime dateTime, String message) throws IOException {
        File logFile = new File(filePath);
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(logFile, true))) { // append mode (přidává)
            pw.print(dateTime.format(DateTimeFormatter.ISO_DATE_TIME) + " ");
            pw.println(message);
        }
    }
}