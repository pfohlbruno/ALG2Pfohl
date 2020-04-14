package com.company;

import java.util.Scanner;

/**
 * Třída pro práci s body (2 nejvzdálenější body, 2 nejbližší body, nejbližší a nejvzdálenější body od počátku).
 * @author  Bruno Pfohl
 */
public class ArrayOfPointsConsoleApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Zpracování sady bodů\n");

        boolean run = true;

        // Hlavní smyčka programu.
        while(run) {
            NShape nShape = new NShape();

            // Vyzvu k zadání vrcholů.
            System.out.print("Počet vrcholů n-úhelníka: ");

            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                nShape.add(getPoint(sc));
            }

            // Znak nového řádku se přenášel dále a dělalo to neplechu ...
            sc.nextLine();

            boolean menuOn = true;
            // Volba operace.
            do {
                System.out.println("\n\nMenu\n" +
                        "1) Přidat nový bod\n" +
                        "2) Nejvzdálenejší bod od počátku\n" +
                        "3) Nejbližší bod od počátku\n" +
                        "4) Nový n-úhelník\n" +
                        "5) Konec");

                System.out.print("Vaše volba: ");

                String input = sc.nextLine();
                int choice;

                // Pokud se nepodaří zpracovat vstup, znovu zobrazím menu.
                try {
                    choice = Integer.parseInt(input);
                } catch (Exception e) {
                    continue;
                }

                switch (choice) {
                    case 1:
                        Point p = getPoint(sc);
                        nShape.add(p);
                        break;
                    case 2:
                        Point furthest = nShape.furthest();
                        System.out.println("Nejvzdálenější bod od počátku je ");
                        System.out.println(furthest.toString());
                        break;
                    case 3:
                        Point nearest = nShape.nearest();
                        System.out.println("Nejbližší bod k počátku je ");
                        System.out.println(nearest.toString());
                    case 4:
                        menuOn = false;
                        break;
                    case 5:
                        menuOn = false;
                        run = false;
                        break;
                }

            } while (menuOn);
        }
    }

    /**
     * Přijme od uživatele vstup (souřadnice) a vytvoří z něj bod, který vrátí
     * @param sc Instance scanneru pro získání vstupu
     * @return Bod
     */
    public static Point getPoint(Scanner sc) {
        System.out.print("Souřadnice X: ");
        double x = sc.nextDouble();

        System.out.print("Souřadnice Y: ");
        double y = sc.nextDouble();

        return new Point(x, y);
    }
}
