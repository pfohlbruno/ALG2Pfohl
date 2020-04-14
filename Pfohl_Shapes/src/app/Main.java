package app;

import comparing.Comparing;
import shapes.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Shape> geoms = new ArrayList<Shape>();

        boolean run = true;

        while (run) {
            printMenu();
            String choice = sc.nextLine();

            switch (choice) {
                case "a":
                    addCircle(sc, geoms);
                    break;
                case "b":
                    addEllipse(sc, geoms);
                    break;
                case "c":
                    addSquare(sc, geoms);
                    break;
                case "d":
                    addRectangle(sc, geoms);
                    break;
                case "e":
                    addTriangle(sc, geoms);
                    break;
                case "f":
                    printGeoms(geoms);
                    break;
                case "g":
                    System.out.println(getShapeWithHighestPerimeter(geoms));
                    break;
                case "h":
                    System.out.println(getShapeWithLowestPerimeter(geoms));
                    break;
                case "i":
                    Shape[] sorted = geoms.toArray(new Shape[0]);
                    Comparing.sort(sorted);
                    Comparing.print(sorted);
                    break;
                default:
                    run = false;
            }
        }
    }

    private static void printMenu() {
        System.out.println(
            "Zvolte jednu z možností\n" +
            "a) Přidat kruh\n" +
            "b) Přidat elipsu\n" +
            "c) Přidat čtverec\n" +
            "d) Přidat obdélník\n" +
            "e) Přidat trojúhelník\n" +
            "f) Vypsat obrazce\n" +
            "g) Max obvod\n" +
            "h) Min obvod\n" +
            "i) Vypsat setřízené podle plochy\n" +
            "cokoliv jiného => konec programu"
        );
    }

    private static void addCircle(Scanner sc, ArrayList<Shape> geoms) {
        System.out.print("Zadejte poloměr kružnice: ");
        double radius = sc.nextDouble();
        sc.nextLine();
        geoms.add(new Circle(radius));
    }

    private static void addEllipse(Scanner sc, ArrayList<Shape> geoms) {
        System.out.print("Zadejte délku hlavní poloosy: ");
        double a = sc.nextDouble();
        sc.nextLine();
        System.out.print("Zadejte délku hlavní poloosy: ");
        double b = sc.nextDouble();
        sc.nextLine();
        geoms.add(new Ellipse(a, b));
    }

    private static void addRectangle(Scanner sc, ArrayList<Shape> geoms) {
        System.out.print("Zadejte šířku obdélníku: ");
        double width = sc.nextDouble();
        sc.nextLine();
        System.out.print("Zadejte výšku obdélníku: ");
        double height = sc.nextDouble();
        sc.nextLine();
        geoms.add(new Rectangle(width, height));
    }

    private static void addSquare(Scanner sc, ArrayList<Shape> geoms) {
        System.out.print("Zadejte délku strany čtverce: ");
        double a = sc.nextDouble();
        sc.nextLine();
        geoms.add(new Square(a));
    }

    private static void addTriangle(Scanner sc, ArrayList<Shape> geoms) {
        System.out.print("Zadejte délku 1. strany: ");
        double a = sc.nextDouble();
        sc.nextLine();
        System.out.print("Zadejte délku 2. strany: ");
        double b = sc.nextDouble();
        sc.nextLine();
        System.out.print("Zadejte délku 3. strany: ");
        double c = sc.nextDouble();
        sc.nextLine();
        geoms.add(new Triangle(a, b, c));
    }

    private static Shape getShapeWithLowestPerimeter(ArrayList<Shape> geoms) {
        double min = Double.MAX_VALUE;
        Shape result = null;

        for (Shape shape : geoms) {
            double perimeter = shape.getPerimeter();

            if (perimeter < min) {
                min = perimeter;
                result = shape;
            }
        }

        return result;
    }

    private static Shape getShapeWithHighestPerimeter(ArrayList<Shape> geoms) {
        double max = -Double.MAX_VALUE;
        Shape result = null;

        for (Shape shape : geoms) {
            double perimeter = shape.getPerimeter();

            if (perimeter > max) {
                max = perimeter;
                result = shape;
            }
        }

        return result;
    }

    private static void printGeoms(ArrayList<Shape> geoms) {
        for (Shape shape : geoms) {
            System.out.println(shape.toString());
        }
    }
}
