package game;

/**
 * Třída reprezentující hrací kartu.
 * @author Bruno Pfohl
 */
public class Card {
    private String symbol; // barva, symbol
    private String value;  // hodnost karty
    private int nPoints;   // hodnota karty

    public Card(String symbol, String value, int nPoints) {
        this.symbol = symbol;
        this.value = value;
        this.nPoints = nPoints;
    }

    /**
     * Vrací symbol karty (žalud, piky, ...).
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Vrací hodnotu karty.
     */
    public String getValue() {
        return value;
    }

    /**
     * Vrací hodnotu karty (1, 2, ...).
     */
    public int getnPoints() {
        return nPoints;
    }
}
