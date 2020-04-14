package com.company;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Vytvořím si instanci Scanneru pro získání vstupu.
        Scanner sc = new Scanner(System.in);

        // Zjistím aktuální datum.
        LocalDate now = java.time.LocalDate.now();

        // Vytvořím instanci kalendáře s aktuálním datem.
        Calendar cal = new Calendar(now.getDayOfMonth(), now.getMonthValue(), now.getYear());

        // Vypíšu menu.
        System.out.println("a - předchozí měsíc\nd - další měsíc\nq - ukončit");

        boolean run = true;

        while(run) {
            // Vypíšu kalendář.
            System.out.println(cal);

            // Získám volbu uživatele.
            char input = sc.next().charAt(0);

            switch (input) {
                case 'a':
                    cal.previousMonth();
                    break;
                case 'd':
                    cal.nextMonth();
                    break;
                case 'q':
                    run = false;
                    break;
            }
        }
    }
}
