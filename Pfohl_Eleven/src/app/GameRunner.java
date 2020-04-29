package app;

/**
 * Třída sloužící pro spuštění hry. Spouští UI/GUI.
 */
public class GameRunner {
    public static void main(String[] args) {
        ConsoleUI game = new ConsoleUI(); // Vytvořím si instanci hry (zatím jen konzolová verze).
        game.start(); // Spustím hru.
    }
}
