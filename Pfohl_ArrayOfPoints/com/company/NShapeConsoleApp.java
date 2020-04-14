package com.company;

import java.util.Scanner;

/**
 * Třída konzolové aplikace umožňující práci s n-úhelníkem (obvod a obsah).
 * @author  Bruno Pfohl
 */
public class NShapeConsoleApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Program n-úhelník.");

        boolean run = true;

        while (run) {
            // Vytvořím si n-úhelník.
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
                        "1) obvod\n" +
                        "2) obsah\n" +
                        "3) nový n-úhelník\n" +
                        "4) konec");

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
                        System.out.format("Obvod %d-uhelníka = %.2f", n, nShape.perimeter());
                        break;
                    case 2:
                        System.out.format("Obsah %d-uhelníka = %.2f", n, nShape.area());
                        break;
                    case 3:
                        menuOn = false;
                        break;
                    case 4:
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
