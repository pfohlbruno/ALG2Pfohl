package shapes;
/**
 * Rozhraní pro objekt reprezentující geometrický útvar u něhož lze zjistit obvod a obsah.
 * @author Bruno Pfohl
 */
public interface Shape {
    /**
     * Vrací plochu(obsah) obrazce.
     * @return Obsah obrazce
     */
    double getArea();

    /**
     * Vrací obvod obrazce.
     * @return Obvod obrazce
     */
    double getPerimeter();
}
