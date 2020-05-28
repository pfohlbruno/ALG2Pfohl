package app;

import code.Hurricane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Úkol dodělám. Omlouvám se, že to není včas...
 * @author Bruno Pfohl
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Hurricane> hurricanes;

        try {
            hurricanes = readHurricaneData("hurricanedata.txt");

            Scanner sc = new Scanner(System.in);

            System.out.print("Zadejte počáteční rok: ");

            int from = Integer.parseInt(sc.nextLine());
            System.out.print("Zadejte koncový rok: ");
            int to = Integer.parseInt(sc.nextLine());
            printDataFromPeriod(hurricanes, from, to);

            System.out.println("Pokračujte stisknutím klávesy enter");
            sc.nextLine();

            System.out.print("Zadejte název hurikánu: ");
            String name = sc.nextLine();
            printInfoByName(hurricanes, name);

            System.out.println("Pokračujte stisknutím klávesy enter");
            sc.nextLine();

            printSorted(hurricanes);


        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printDataFromPeriod(List<Hurricane> hurricanes, int from, int to) {
        List<Hurricane> filtered = hurricanes.stream()
            .filter(h -> h.getYear() >= from && h.getYear() <= to)
            .collect(Collectors.toList());

        for (Hurricane hurricane : filtered) {
            System.out.println(hurricane.toString());
        }
    }

    private static void printInfoByName(List<Hurricane> hurricanes, String name) {
        boolean found = false;

        for (Hurricane hurricane : hurricanes) {
            if (hurricane.getName().contains(name)) {
                found = true;
                System.out.format("Název: %s; Rychlost %d km/h; Kategorie: %d %n", hurricane.getName(), hurricane.getSpeedInKmH(), hurricane.getCategory());
            }
        }

        if (!found) {
            System.out.println("Hurikán se jménem " + name + " nebyl nalezen.");
        }
    }

    private static void printSorted(List<Hurricane> hurricanes) {
        Collections.sort(hurricanes);
        for (Hurricane hurricane : hurricanes) {
            System.out.println(hurricane.toString());
        }
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
}