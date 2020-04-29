package game;

import java.util.Arrays;
import java.util.List;

public class Board implements BoardInterface{
    private Card[] cards;
    private Deck deck;

    public Board(){
        // Vytvořím balíček karet.
        this.deck = new Deck(DataStore.loadSymbols(), DataStore.loadValues(), DataStore.loadNPoints());
        // Rozdám karty.
        this.cards = new Card[nCards()];
        for (int i = 0; i < nCards(); i++) {
            this.cards[i] = this.deck.deal();
        }
    }

    @Override
    public String gameName() {
        return "Jedenáctka";
    }

    @Override
    public int nCards() {
        return DataStore.getNCards();
    }

    @Override
    public int getDeckSize() {
        return this.deck.getDeckSize();
    }

    @Override
    public String getCardDescriptionAt(int index){
        if(this.cards[index] == null){
            return " ";
        }
        return this.cards[index].getSymbol() + "-" + this.cards[index].getValue();
    }

    @Override
    public boolean anotherPlayIsPossible() {
        // Projedu všechny možné trojice karet.
        for (int i = 0; i < nCards(); i++) {
            for (int j = i + 1; j < nCards(); j++) {

                // Zkontroluji, jestli je kombinace dvou zvolených karet validní.
                if (isCombinationValid(new int[] {i, j})) {
                    return true;
                }

                // Pro dvojici vezmu postupně všechny zbylé karty do tretice a testuji, jestli se jedná o trojici JQK.
                for (int k = j + 1; k < nCards(); k++) {
                    if (isCombinationValid(new int[] {i, j, k})) {
                        return true;
                    }
                }
            }
        }

        // V tomto bodě je jasné, že se nepodařilo najít dvojici či trojice o celkovém součtu 11. Vracím tedy false.
        return false;
    }

    @Override
    public boolean playAndReplace(int[] iSelectedCards) {
        boolean canBePlayed = isCombinationValid(iSelectedCards);

        // Pokud zvolená kombinace karet lze zahrát, nahradím karty jinými kartami z balíčku.
        if (canBePlayed) {
            // Každou ze vzolených karet nahradím novou kartou z balíčku.
            for (int i : iSelectedCards) {
                this.cards[i] = this.deck.deal();
            }
        }

        return canBePlayed;
    }

    private boolean isCombinationValid(int[] iSelectedCards) {

        // Pokud kontroluju kombinaci 2 karet, pouze kontroluji, jestli je jejich součet 11.
        if (iSelectedCards.length == 2) {
            Card cardA = this.cards[iSelectedCards[0]];
            Card cardB = this.cards[iSelectedCards[1]];
            return cardA != null && cardB != null && cardA.getnPoints() + cardB.getnPoints() == 11;
        }
        else {
            // Jinak už může být kombinace validní pouze, pokud se jedná o trojici (konrétně J, Q, K).
            List<String> triple = Arrays.asList(DataStore.getTriple());

            for(int i = 0; i < iSelectedCards.length; i++) {
                Card card = this.cards[iSelectedCards[i]];

                if (card != null) {
                    triple.remove(card);
                }
            }

            return triple.size() == 0;
        }
    }

    @Override
    public boolean isWon() {
        return this.deck.getDeckSize() == 0 && cards.length == 0;
    }
}
