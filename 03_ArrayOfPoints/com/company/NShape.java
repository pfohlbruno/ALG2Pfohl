package com.company;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Třída zachycující n-úhelník.
 * @author  Bruno Pfohl
 */
public class NShape {
    // data
    private ArrayList<Point> points = new ArrayList<Point>();

    // constructor

    public NShape() {

    }

    public NShape(Point[] points) {
        this.points = new ArrayList<Point>(Arrays.asList(points));
    }

    public NShape(ArrayList<Point> points) {
        this.points = (ArrayList<Point>)points.clone();
    }

    /**
     * Přidá tomuto n-úhelníku nový bod.
     * @param p nový bod
     */
    public void add(Point p) {
        this.points.add(p);
    }

    /**
     * Přidá tomuto n-úhelníku nový bod.
     * @param x horizontální část souřadnice bodu
     * @param y vertikální část souřadnice bodu
     */
    public void add(double x, double y) {
        add(new Point(x, y));
    }

    /**
     * Vrací obvod tohoto n-úhelníku.
     * @return obvod n-úhelníku
     */
    public double perimeter() {
        double perimeter = this.points.get(0).distanceTo(this.points.get(this.points.size() - 1));

        for (int i = 0; i < this.points.size() - 1; i++){
            perimeter += this.points.get(i).distanceTo(this.points.get(i + 1));
        }

        return perimeter;
    }

    /**
     * Vrací obsah obsah tohoto n-úhelníku.
     * @return obsah n-úhelníku
     */
    public double area() {
        int length = this.points.size();

        // Poslední a první bod.
        Point p1 = this.points.get(0);
        Point p2 = this.points.get(length - 1);
        double area = Math.abs(p2.getX()*p1.getY() - p1.getX()*p2.getY());

        for (int i = 0; i < length - 1; i++) {
            p1 = this.points.get(i);
            p2 = this.points.get(i + i);
            area += p1.getX()*p2.getY() - p2.getX()*p1.getY();
        }

        area = Math.abs(area) * 0.5f;

        return area;
    }

    /**
     * Vrací bod, který je neblíže od počátku.
     * @return bod nejblíže od počátku.
     */
    public Point nearest() {
        double min = Double.MAX_VALUE;
        Point nearest = null;

        for (Point p: this.points) {
            double distance = p.distance();
            if (distance < min) {
                min = distance;
                nearest = p;
            }
        }

        return nearest;
    }

    /**
     * Vrací bod, který je neblíže od počátku.
     * @return bod nejblíže od počátku.
     */
    public Point nearestFromEachOther(Point) {
        double min = Double.MAX_VALUE;
        Point nearest = null;

        for (Point p: this.points) {
            double distance = p.distance();
            if (distance < min) {
                min = distance;
                nearest = p;
            }
        }

        return nearest;
    }

    /**
     * Vrací bod, který je nejdále od počátku.
     * @return bod nejdále od počátku.
     */
    public Point furthest() {
        double max = -Double.MAX_VALUE;
        Point furthest = null;

        for (Point p: this.points) {
            double distance = p.distance();
            if (distance > max) {
                max = distance;
                furthest = p;
            }
        }

        return furthest;
    }
}
