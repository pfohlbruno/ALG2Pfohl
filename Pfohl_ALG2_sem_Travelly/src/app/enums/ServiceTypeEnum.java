package app.enums;

/**
 * Typ služby poskytovaný hotelem (stravování).
 */
public enum ServiceTypeEnum{
    /**
     * Polopenze
     */
    halfBoard("polopenze"),
    /**
     * Plná penze
     */
    fullBoard("plná penze"),
    /**
     * All inclusive
     */
    allInclusive("all inclusive"),
    /**
     * Bez stravování
     */
    poorFella("bez stravování");

    private String name;

    ServiceTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}