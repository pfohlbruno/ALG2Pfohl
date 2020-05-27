package ui;

import app.Competition;

import java.util.Scanner;

/**
 * Hlavní třída programu.
 * @author Bruno Pfohl
 */
public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Competition c = new Competition();
        System.out.println("Zadejte názvy vstupních souborů");
        try{
            while(true){
                try {
                    String startFile = sc.next();
                    String finishFile = sc.next();
                    c.load(startFile, finishFile);
                    break;
                }catch(FileNotFoundException e){
                    System.out.println("Zadany neexistujici subor. Zadej znovu.");
                    //e.printStackTrace(); vhodné pro debuggování
                }
            }
            System.out.println(c.getResults());
            System.out.println("Zadej nazev vystupniho souboru");
            String resultFile = sc.next();
            c.saveResults(resultFile);
            System.out.println("Data byla ulozena");
        }catch(IOException e){
            System.out.println("Chyba pri cteni a zapisu");
        }
    }
}
