package com.company;

public class Point {
    private double x;
    private double y;
    private double distance;

    // constructors

    public Point() {
        this.x = 0;
        this.y = 0;
        this.distance = 0;
    }

    // overloaded constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        this.distance = distance();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    // methods
    public double distance() {
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }

    public double distanceTo(Point p) {
        return distanceBetween(this, p);
    }

    // statická nemá nic společného s objektem
    public static double distanceBetween(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}
