package shapes;

/**
 * Třída reprezentující elipsu, která je definována délkou hlavní a vedlejší poloosy.
 * @author Bruno Pfohl
 */
public class Ellipse implements Shape {
    private double a;
    private double b;

    public Ellipse(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getArea() {
        return Math.PI * this.a * this.b; // Πab
    }

    public double getPerimeter() {
        // Peanův vzorec (odchylka menší než 0,02 % až pro epsilon < 0,8.
        return (Math.PI/2)*(this.a + this.b + Math.sqrt(2*(this.a*this.a + this.b*this.b)));

    }

    @Override
    public String toString() {
        return String.format("Elipsa :{ Hlavní poloosa: %.2f; Vedlejší poloosa: %.2f; Obvod: %.2f; Obsah: %.2f }", this.a, this.b, getPerimeter(), getArea());
    }
}
