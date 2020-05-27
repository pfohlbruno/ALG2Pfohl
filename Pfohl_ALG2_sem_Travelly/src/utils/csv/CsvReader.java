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

    /**
     * Konstruktor pro vytvoření instance čtečky.
     * @param type Objektový typ, na který se budou jednotlivé řádky mapovat.
     * @param file Soubor, se kterým reader pracuje.
     */
    public CsvReader(final Class<T> type, String file) {
        this.genericType = type;
        this.file = file;
    }

    /**
     * Konstruktor pro vytvoření instance čtečky se specifickým separačním znakem.
     * @param type Objektový typ, na který se budou jednotlivé řádky mapovat.
     * @param file Soubor, se kterým reader pracuje.
     * @param separator Separační znak jednotlivých polí.
     */
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

    /**
     * Vrací instanci čtečky, na které se můžou řetězit další příkazy.
     */
    public CsvToBeanBuilder<T> getBeanBuilder() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(this.file));
        return new CsvToBeanBuilder(reader)
                .withSeparator(this.separator)
                .withType(this.genericType);
    }
}

