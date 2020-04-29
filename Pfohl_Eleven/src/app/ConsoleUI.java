package app;

import game.Board;
import game.BoardInterface;

import java.util.Scanner;

/**
 * UI for card games e.g. Eleven game
 * @author janvit
 */
public class ConsoleUI {
    public static Scanner sc = new Scanner(System.in);

    private BoardInterface board;

    public void start() {
        boolean nextGame = true;
        while (nextGame) {
            board = new Board(); // Vytvořím si instanci hry.
            playGame(); // Započnu hru.
            System.out.println("Chceš hrát znovu? a/n"); // V tomto bodě už jsem dohrál. Chce uživatel hrát znovu?
            nextGame = sc.next().equalsIgnoreCase("a"); // Po stisknutí "a" se hraje znovu. Jinak hra končí.
        }
    }

    private void playGame() {
        System.out.println("***************** " + board.gameName() + " ********************");
        displayDeck();
        displayCards();
        while (board.anotherPlayIsPossible()) {
            System.out.println("Vyběr karty:");
            String[] selectedCards = sc.nextLine().split(" +"); // separator is one or more spaces
            int[] iSelectedCards = toInt(selectedCards); // changes String positions to int indexes
            if (board.playAndReplace(iSelectedCards)) {
                displayDeck();
                displayCards();
            } else {
                System.out.println("Nepovolený tah");
            }
        }
        if (board.isWon()) {
            System.out.println("Gratuluji!");
        } else {
            System.out.println("Nelze hrát");
        }
    }

    private void displayCards() {
        for (int i = 0; i < board.nCards(); i++) {
            System.out.format("%1d. %10s   ", i + 1, board.getCardDescriptionAt(i));
            System.out.println("");
        }
    }

    private void displayDeck() {
        System.out.println("V balíčku je " + board.getDeckSize() + " karet");
    }

    private int[] toInt(String[] selectedCards) {
        int[] iSelectedCards = new int[selectedCards.length];
        for (int i = 0; i < selectedCards.length; i++) {
            iSelectedCards[i] = Integer.parseInt(selectedCards[i]) - 1; // position to index
        }
        return iSelectedCards;
    }
}