package cmd.code;

import cmd.app.CmdEditor;

import java.util.Scanner;

/**
 * Hlavní třída programu
 * @author Bruno Pfohl
 */
public class CmdUI {

    // Instance Scanneru pro získání vstupu uživatele.
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Vytvoření instance příkazové řádky.
        CmdInterface cmd = new CmdEditor();

        String line;
        // Dokud příkazová řádka běží...
        while(cmd.isRunning()) {
            // Vypíšu aktuální pracovní složku.
            System.out.print(cmd.getActualDir() + "$ ");
            // Získám vstup od uživatele.
            line = sc.nextLine();
            try {
                // Pokusím se zpracovat příkaz a vypsat jeho výstup.
                System.out.println(cmd.parseAndExecute(line, cmd));
            } catch (RuntimeException e) {
                // Pokud něco selže, vypíšu chybovou hlášku.
                System.out.println(e.getMessage());
            }
        }
    }
}
