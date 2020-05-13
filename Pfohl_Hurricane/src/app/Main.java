package app;

import code.Hurricane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Úkol dodělám. Omlouvám se, že to není včas...
 * @author Bruno Pfohl
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Hurricane> hurricanes;

        try {
            hurricanes = readHurricaneData("hurricanedata.txt");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Scanner sc = new Scanner(System.in);
        printMenu();

        int option = sc.nextInt();

        switch (option) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("Volba nerozeznána");
                printMenu();
                break;
        }
    }

    private static void printDataFromPeriod(Scanner sc) {
        int from = sc.nextInt();
        int to = sc.nextInt();


    }

    private static ArrayList<Hurricane> readHurricaneData(String path) throws FileNotFoundException, IOException {
        ArrayList<Hurricane> hurricanes = new ArrayList<>();
        File file = new File(path);
        Scanner sc = new Scanner(file);

        while(sc.hasNext()){
            int year = sc.nextInt();
            String month = sc.next();
            int pressure = sc.nextInt();
            int speed = sc.nextInt();
            String name = sc.next();

            Hurricane h = new Hurricane(year, month, pressure, speed, name);
            hurricanes.add(h);
        }

        return hurricanes;
    }

    private static void printMenu() {
        System.out.println(
                "1) Vypište informace o všech hurikánech v období zadaném uživatelem. (od roku .. do roku)\n" +
                "2) Vypište kategorii a rychlost v km/h hurikánu zadaného jménem od uživatele\n" +
                "3) Vypište informace o hurikánech setříděných podle rychlosti"
        );
    }
}
