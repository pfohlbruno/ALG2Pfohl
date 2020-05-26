package app.data.providers;

import app.entities.EntityBase;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.List;

public interface IProvider<T extends EntityBase> {
    /**
     * Načte do provideru data z CSV souboru.
     */
    void load() throws IOException;

    /**
     * Uloží data z provideru do příslušného CSV souboru (kompletně přepíše celý CSV soubor!).
     */
    void save() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException;

    /**
     * Vrací záznam se specifikovaným identifikačním klíčem.
     * @param id Unikátní identifikační klíč objektu, který se má mezi daty vyhledat.
     * @return Objekt se specifikovaným id.
     */
    T getById(String id);

    /**
     * Vrací všechny záznamy.
     */
    List<T> getAll();

    /**
     * Poskytuje cestu k CSV souboru, ve kterém jsou uložena data.
     * @return Cesta k CSV souboru na disku.
     */
    String getSourcePath();
}
