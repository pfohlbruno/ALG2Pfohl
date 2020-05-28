package app.entities;

import com.opencsv.bean.CsvBindByName;

import java.util.UUID;

/**
 * Bázová třída datové entity (všechny entity mají společnou "vlastnost" id).
 * @author Bruno Pfohl
 */
public class EntityBase {
    @CsvBindByName
    protected String id;

    public EntityBase() {

    }

    public EntityBase(String id) {
        this.id = id;
    }

    /**
     * Vrací id datové entity.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Vrací unikátní id pro datovou entitu.
     */
    public static String GenerateNewId () {
        return UUID.randomUUID().toString();
    }
}
