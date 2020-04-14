package shapes;

/**
 * Třída reprezentující obdélník, který je definován 2 stranami.
 * @author Bruno Pfohl
 */
public class Rectangle implements Shape {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public double getArea() {
        return this.width*this.height;
    }

    public double getPerimeter() {
        return 2*(this.height + this.width);
    }

    @Override
    public String toString() {
        return String.format("Obdélník :{ Šířka: %.2f; Výška: %.2f; Obvod: %.2f; Obsah: %.2f }", this.width, this.height, getPerimeter(), getArea());
    }
}
