package shapes;

import comparing.CompareInterface;

/**
 * Třída reprezentující kruh, který je elipsou se stejnou délkou hlavní a vedlejší poloosy.
 * @author Bruno Pfohl
 */
public class Circle  extends Ellipse{
    public Circle(double radius) {
        super(radius, radius);
    }

    public double getRadius() {
        return this.getA();
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*getRadius(); // 2Πr
    }

    @Override
    public String toString() {
        return super.toString() + String.format(":{ Poloměr: %.2f; Obvod: %.2f; Obsah: %.2f }", getRadius(), getPerimeter(), getArea());
    }
}
