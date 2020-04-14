package shapes;

/**
 * Třída reprezentující trojúhelník definovaný 3mi stranami.
 * @author Bruno Pfohl
 */
public class Triangle extends Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public double getArea() {
        // Přo výpočet plochy je využit Heronův vzorec.
        double s = getPerimeter() / 2;
        return Math.sqrt(s*(s - a)*(s - b)*(s - c));
    }

    @Override
    public double getPerimeter() {
        return this.a + this.b + this.c;
    }

    @Override
    public String toString() {
        return String.format("%s :{ 1.strana: %.2f; 2. strana: %.2f; 3.strana: %.2f; Obvod: %.2f; Obsah: %.2f }", getShapeName(), this.a, this.b, this.c , getPerimeter(), getArea());
    }
}
