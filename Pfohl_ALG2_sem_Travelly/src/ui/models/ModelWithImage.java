package ui.models;

/**
 * Bázová třída pro model s obrázkem.
 * @author Bruno Pfohl
 */
public class ModelWithImage {
    protected String imgPath;

    public ModelWithImage(String imgPath) {
        this.imgPath = imgPath;
    }

    /**
     * Vrací cestu k obrázku hotelu.
     */
    public String getImgPath() {
        return imgPath;
    }
}