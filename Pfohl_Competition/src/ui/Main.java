package ui;

import app.Competition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hlavní třída programu.
 * @author Bruno Pfohl
 */
public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Competition c = new Competition();
        System.out.println("Zadejte názvy vstupních souborů: ");
        try{
            while(true){
                try {
                    String startFile = sc.next();
                    String finishFile = sc.next();
                    c.load(startFile, finishFile);
                    break;
                } catch(FileNotFoundException e){
                    System.out.println("Vstupní soubor neexistuje. Zadej znovu.");
                } catch (Exception e) {
                   System.out.println(e.getMessage());
                }
            }
            System.out.println(c.getResults());
            System.out.println("Zadej název výstupního souboru: ");
            String resultFile = sc.next();
            c.saveResults(resultFile);
            System.out.println("Výsledky soutěže byly uloženy.");
        } catch(IOException e){
            System.out.println("Chyba pri čtení či zápisu");
        }
    }
}