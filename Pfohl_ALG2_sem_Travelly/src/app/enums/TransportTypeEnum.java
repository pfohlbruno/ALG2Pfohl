package app.enums;

/**
 * Typ dopravy.
 */
public enum TransportTypeEnum {
    /**
     * Autobusem
     */
    bus("Autobusem"),
    /**
     * Letadlem
     */
    plane("Letecky"),
    /**
     * Vlastní doprava.
     */
    own("Vlastní");

    private String name;

    TransportTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
