package com.company;

public class ArrayOfPoints {

    public static void main(String[] args) {
        Point p = new Point();
        Point p1 = new Point(4, 3);

        System.out.println(p1);
        System.out.format("Vzdálenost od počátku: %.2f %n", p1.distance());

        Point p2 = new Point(6, 3);
        System.out.println(p2);

        System.out.format("Vzdálenost bodu p2 od bodu p1: %.2f", p2.distanceTo(p1));
    }

    /*
    Vytvořte program, který uživateli umožní interaktivně zadávat vrcholy n-úhelníka a počítat jeho obvod a plochu.
     */
}
