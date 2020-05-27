package app.data.providers;

import app.entities.EntityBase;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import utils.csv.CsvReader;
import utils.csv.CsvWriter;

import java.io.IOException;
import java.util.List;

/**
 * Bázová třída provideru dat (z csv souboru).
 * @param <T> Generický parametr, který určuje s kterým datovým objektem tato třída pracuje.
 */
public abstract class ProviderBase<T extends EntityBase> implements IProvider<T> {
    protected List<T> data;
    private Class<T> genericType;

    protected ProviderBase(final Class<T> type) throws IOException {
        this.genericType = type;
        load();
    }

    /**
     * Načte do provideru data z CSV souboru.
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
        for (T o : this.data) {
            if (o.getId().equals(id)) {
                return o;
            }
        }

        return null;
    }

    /**
     * Vrací všechny záznamy.
     */
    public List<T> getAll() {
        return this.data;
    }

    public abstract String getSourcePath();
}
