package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class NShape {
    // data
    private ArrayList<Point> points = new ArrayList<Point>();

    // constructor

    public NShape() {

    }

    public NShape(Point[] points) {
        this.points = new ArrayList<Point>(Arrays.asList(points));
    }

    // kopie
    public NShape(ArrayList<Point> points) {
        this.points = points;
    }

    public void add(Point p) {
        this.points.add(p);
    }

    public void add(double x, double y) {
        add(new Point(x, y));
    }

    public double perimeter() {
        double perimeter = this.points.get(0).distanceTo(this.points.get(this.points.size() - 1));

        for (int i = 0; i < this.points.size() - 1; i++){
            perimeter += this.points.get(i).distanceTo(this.points.get(i + 1));
        }

        return perimeter;
    }

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
}
