package app.entities;

import com.opencsv.bean.CsvBindByName;

import java.util.UUID;

public class EntityBase {
    @CsvBindByName
    protected String id;

    public EntityBase() {

    }

    public EntityBase(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public static String GenerateNewId () {
        return UUID.randomUUID().toString();
    }
}
