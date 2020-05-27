package utils.csv;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Generická třída pro zapisování dat do CSV souboru, která každý řádek chápe jako objekt typu T.
 * @author Bruno Pfohl
 */
public class CsvWriter<T> {
    private String file;
    private char separator = ';';

    /**
     * Konstruktor pro vytvoření instance writeru.
     * @param file Soubor, se kterým writer pracuje.
     */
    public CsvWriter(String file) {
        this.file = file;
    }

    /**
     * Konstruktor pro vytvoření instance writeru se zvláštním separačním znakem.
     * @param file Soubor, se kterým reader pracuje.
     * @param separator Separační znak oddělující jednotlivá pole.
     */
    public CsvWriter(String file, char separator) {
        this(file);
        this.separator = separator;
    }

    /**
     * Zapíše všechny objekty předané v parametru do souboru CSV.
     * @param beans Objekty, jednotlivé řádky souboru, které se mají zapsat do souboru.
     */
    public void writeAll(List<T> beans) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        // Vytvořím instanci writeru.
        Writer writer = Files.newBufferedWriter(Paths.get(this.file));

        // Vytvořím instanci CSV writeru.
        StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                .withSeparator(this.separator)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .build();

        // Zapíšu změny.
        beanToCsv.write(beans);

        // Uzavřu writer (v tomto bodě se data uloží).
        writer.close();
    }
}
