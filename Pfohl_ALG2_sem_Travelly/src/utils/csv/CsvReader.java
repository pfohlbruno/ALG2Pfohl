package utils.csv;

import app.data.providers.ProviderBase;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Generická třída pro čtení z CSV souboru, která každý řádek chápe jako objekt typu T.
 * @author Bruno Pfohl
 */
public class CsvReader<T> {
    private String file;
    private char separator = ';';
    private  Class<T> genericType;

    public CsvReader(final Class<T> type, String file) {
        this.genericType = type;
        this.file = file;
    }

    public CsvReader(final Class<T> type, String file, char separator) {
        this(type, file);
        this.separator = separator;
    }

    /**
     * Vrací všechny objekty ze souboru.
     */
    public List<T> readAll() throws IOException {
        return getBeanBuilder().build().parse();
    }

    public CsvToBeanBuilder<T> getBeanBuilder() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(this.file));
        return new CsvToBeanBuilder(reader)
                .withSeparator(this.separator)
                .withType(this.genericType);
    }
}