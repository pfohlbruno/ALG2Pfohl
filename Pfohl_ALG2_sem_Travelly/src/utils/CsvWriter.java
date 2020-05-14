package utils;

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
    private  Class<T> genericType;

    public CsvWriter(final Class<T> type, String file) {
        this.genericType = type;
        this.file = file;
    }

    public CsvWriter(final Class<T> type, String file, char separator) {
        this(type, file);
        this.separator = separator;
    }

    /**
     * Zapíše všechny objekty předané v parametru do souboru CSV.
     * @param beans Objekty, jednotlivé řádky souboru, které se mají zapsat do souboru.
     */
    public void writeAll(List<T> beans) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        Writer writer = Files.newBufferedWriter(Paths.get(this.file));
        StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                .withSeparator(this.separator)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .build();

        beanToCsv.write(beans);
    }
}
