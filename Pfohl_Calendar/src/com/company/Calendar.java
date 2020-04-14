package com.company;

import java.util.Arrays;

/**
 * Třída reprezentující kalendář.
 * Uchovává aktuálně zvolené datum a poskytuje textový výstup (vypsání aktuálně zvoleného měsíce).
 * @author Bruno Pfohl
 */
public class Calendar {
    private int day;
    private int month;
    private int year;

    private static final int[] DAYS = {
        31, // leden
        28, // únor
        31, // březen
        30, // duben
        31, // květen
        30, // červen
        31, // červenec
        31, // srpen
        30, // září
        31, // říjen
        30, // listopad
        31  // prosinec
    };

    private static final String[] DAYS_OF_WEEK = { "PO", "ÚT", "ST", "ČT", "PÁ", "SO", "NE" };

    public Calendar(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void previousMonth() {
        this.day = 1;

        if (--this.month == 0) {
            this.month = 12;
            this.year--;
        }
    }

    public void nextMonth() {
        this.day = 1;

        if (++this.month == 13) {
            this.month = this.month % 12;
            this.year++;
        }
    }

    public static int getDayOfWeek(int day, int month, int year) {
        int q = day;
        int m = (month < 3) ? month + 12 : month;
        int K = year % 100;
        int J = year / 100;

        int h = (q + (13*(m + 1)/5) + K + (K/4) + (J/4) + (5*J)) % 7;
        int d = ((h + 5) % 7) + 1;

        return d;
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public static int getNumberOfDaysInYear(int year) {
        return isLeapYear(year) ? 366 : 365;
    }

    @Override
    public String toString() {
        // Příznak přestupného roku.
        boolean isLeapYear = isLeapYear(this.year);
        // Zjistím od jaké pozice zleva mám vypisovat první den měsíce.
        int dayOffset = getDayOfWeek(1, this.month, this.year) - 1;
        // Počet dní ve zvoleném měsíci.
        int daysInMonth = DAYS[this.month - 1];
        // Šířka tabulky.
        int columns = DAYS_OF_WEEK.length;
        // Výška tabulky.
        int cells = 7*(int)Math.ceil((dayOffset + daysInMonth) / 7f);

        // Pokud se jedná o přestupný rok a je zvolen únor, přidám k počtu dní 1 den.
        if (this.month == 2 && isLeapYear){
            daysInMonth++;
        }

        StringBuilder sb = new StringBuilder("");

        // Vypíšu zvolené datum.
        sb.append(String.format("Zvolené datum: %d. %d. %d %n", this.day, this.month, this.year));

        // Vypíšu jestli zvolený rok je/není přestupný.
        sb.append("Rok " + this.year + (isLeapYear ? " je" : " není") + " přestupný.\n\n");

        // Vypíšu záhlaví tabulky.
        sb.append(buildRow(DAYS_OF_WEEK));

        String[] values = new String[cells];

        for (int i = 0; i < values.length; i++) {
            values[i] = "";
        }

        for (int i = dayOffset; i < dayOffset + daysInMonth; i++) {
            int day = i - dayOffset + 1;
            values[i] = (day == this.day ? "*" : "") + Integer.toString(day);
        }

        for (int i = 0; i < cells; i += 7) {
            sb.append(buildRow(Arrays.copyOfRange(values, i, i + 7)));
        }

        return sb.toString();
    }

    private String buildRow(String[] values) {
        return String.format("|%-5s|%-5s|%-5s|%-5s|%-5s|%-5s|%-5s\n", values);
    }
}
