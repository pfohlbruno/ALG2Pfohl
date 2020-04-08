package shapes;
/**
 * Třída reprezentující geometrický útvar u něhož lze zjistit obvod a obsah.
 * @author Bruno Pfohl
 */
public abstract class Shape {
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
}
