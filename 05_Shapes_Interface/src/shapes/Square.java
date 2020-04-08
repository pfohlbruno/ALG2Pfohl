package shapes;

/**
 * Třída reprezentující čtverec, který je zvláštní případ obdélníku, kde výška je stejná jako šířka.
 * @author Bruno Pfohl
 */
public class Square extends Rectangle {
    public Square(double sideLength) {
        super(sideLength, sideLength);
    }

    public double getSideLength() {
        return this.getHeight();
    }

    @Override
    public String toString() {
        return String.format("Délka strany :{ Hlavní poloosa: %.2f; Obvod: %.2f; Obsah: %.2f }", this.getSideLength(), getPerimeter(), getArea());
    }
}
