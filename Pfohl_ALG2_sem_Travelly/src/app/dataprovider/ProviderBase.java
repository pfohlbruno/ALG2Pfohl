package app.dataprovider;

import app.entities.EntityBase;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.commons.beanutils.converters.DateConverter;
import utils.csv.CsvReader;
import utils.csv.CsvWriter;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Bázová třída provideru dat (z csv souboru).
 * @param <T> Generický parametr, který určuje s kterým datovým objektem tato třída pracuje.
 */
public abstract class ProviderBase<T> {
    protected List<T> data;
    private Class<T> genericType;

    public ProviderBase(final Class<T> type) throws IOException {
        this.genericType = type;
        registerDateConverter();
        load();
    }

    /**
     * Načte do provideru data z CSV souboru.
     * @throws IOException
     */
    public void load() throws IOException {
        this.data = new CsvReader<T>(this.genericType, getSourcePath()).readAll();
    }

    /**
     * Uloží data z provideru do příslušného CSV souboru (kompletně přepíše celý CSV soubor!).
     */
    public void save() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        new CsvWriter<T>(this.genericType, getSourcePath()).writeAll(this.data);
    }

    /**
     * Vrací záznam se specifikovaným identifikačním klíčem.
     * @param id Unikátní identifikační klíč objektu, který se má mezi daty vyhledat.
     * @return Objekt se specifikovaným id.
     */
    public T getById(String id) {
        return this.data
                .stream()
                .filter(o -> ((EntityBase)o).getId() == id)
                .findFirst()
                .get();
    }

    private static void registerDateConverter() {
        DateConverter dc = new DateConverter();
        dc.setUseLocaleFormat(true);
        dc.setPatterns(new String[] { "dd-MM-yyyy", "dd-MM-yyyy HH:mm:ss" });
        org.apache.commons.beanutils.ConvertUtils.register(dc, Date.class);
    }


    /**
     * Vrací všechny záznamy.
     */
    public List<T> getAll() {
        return this.data;
    }

    /**
     * Poskytuje cestu k CSV souboru, ve kterém jsou uložena data.
     * @return Cesta k CSV souboru na disku.
     */
    public abstract String getSourcePath();
}
