package com.company;

public class MainStaticArray {

    public static void main(String[] args) {
        Point[] a = new Point[4];
        a[0] = new Point(3, 4);
        a[1] = new Point(6, 4);
        a[2] = new Point(6, 8);
        a[3] = new Point(3, 8);

        System.out.println(perimeter(a));
    }

    public static double perimeter(Point[] a) {
        double perimeter = a[0].distanceTo(a[a.length - 1]);

        for (int i = 0; i < a.length - 1; i++){
            perimeter += a[i].distanceTo(a[i + 1]);
        }

        return perimeter;
    }
}