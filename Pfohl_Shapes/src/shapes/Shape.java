package shapes;
/**
 * Třída reprezentující geometrický útvar u něhož lze zjistit obvod a obsah.
 * @author Bruno Pfohl
 */
public abstract class Shape {
    // data
    protected String name = "Geometric shape";

    // methods
    /**
     * Vrací plochu(obsah) obrazce.
     * @return Obsah obrazce
     */
    public abstract double getArea();

    /**
     * Vrací obvod obrazce.
     * @return Obvod obrazce
     */
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return name + " " + getShapeName();
    }

    public String getShapeName() {
        return this.getClass().getSimpleName();
    }
}
