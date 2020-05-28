package game;

import java.util.Arrays;

/**
 * Třída obsahující informace o kartách (hodnoty, symboly, ...).
 * @author Bruno Pfohl
 */
public class DataStore {
    private static String[] values
            = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    private static String[] symbols
            = {"červená", "zelená", "žalud", "koule"};

    private static int[] nPoints
            = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

    private static int nCards = 9;

    private static String[] triple = {"J", "Q", "K"};

    public static String[] loadSymbols() {
        return Arrays.copyOf(symbols, symbols.length);
    }

    public static String[] loadValues() {
        return Arrays.copyOf(values, values.length);
    }

    public static int[] loadNPoints(){
        return Arrays.copyOf(nPoints, nPoints.length);
    }

    public static int getNCards(){
        return nCards;
    }

    public static String[] getTriple(){
        return Arrays.copyOf(triple, triple.length);
    }
}
