package game;

import java.util.*;

/**
 * Třída reprezentující balíček karet.
 * @author janvit
 */
public class Deck {
    // Nemusí se měnit v průběhu hry, stav balíčku může být reprezentován počtem zbývajících karet.
    private List<Card> deckCards;
    private int deckSize; // Aktuální počet karet v balíčku.

    public Deck(String[] symbols, String[] values, int[] nPoints) {
        deckCards = new ArrayList<>();
        generateAllCards(symbols, values, nPoints);
        this.deckSize = deckCards.size();
        shuffle();
    }

    /**
     * Inicializuje balíček karet.
     */
    private void generateAllCards(String[] symbols, String[] values, int[] nPoints) {
        // Pro každou barvu zvlášť vytvořím karty.
        for (String symbol : symbols) {
            for (int i = 0; i < values.length; i++) {
                String value = values[i];
                int points = nPoints[i];
                // Přidám kartu do balíčku.
                this.deckCards.add(new Card(symbol, value, points));
            }
        }
    }

    /**
     * Zamíchá balíček karet.
     */
    private void shuffle() {
        // Fisher-Yates shuffle algorithm

        // Generátor náhodných čísel.
        Random rnd = new Random();

        // Celkový počet hracích karet.
        int totalCards = this.deckCards.size();

        for (int i = totalCards - 1; i > totalCards - getDeckSize(); i--) {
            // Vyměním akuální kartu s náhodnout kartou.
            Collections.swap(this.deckCards, i, rnd.nextInt(i + 1));
        }
    }

    /**
     * Rozdá kartu z balíčku.
     * @return Instanci karty, která je na řadě nebo null, pokud je balíček prázdný.
     */
    public Card deal() {
        // Pokud jsou v balíku karty, vrátím vrchní kartu (uberu ji), jinak vracím null.
        return deckSize == 0 ? null : this.deckCards.get(--deckSize);
    }

    public int getDeckSize() {
        return this.deckSize;
    }

    public boolean isEmpty() {
        return getDeckSize() == 0;
    }
}
