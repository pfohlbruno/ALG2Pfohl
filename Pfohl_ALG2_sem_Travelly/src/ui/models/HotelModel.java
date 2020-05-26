package ui.models;

import app.entities.Hotel;

/**
 * Model hotelu určený pro zobrazování dat v UI.
 * @author Bruno Pfohl
 */
public class HotelModel implements IWithImage {
    private String id;
    private String name;
    private String location;
    private int stars;
    private String imgPath;

    /**
     * Privátní konstruktor, který vrácí instanci objektu vytvořenou z entity.
     * @param hotel Entita hotelu, ze které se má vytvořit model.
     */
    private HotelModel(Hotel hotel) {
        this.id = hotel.getId();
        this.imgPath = hotel.getImgPath();
        this.name = hotel.getName();
        this.location = hotel.getPlace();
        this.stars = hotel.getStars();
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getStars() {
        return stars;
    }

    /**
     * Vrací instanci modelu hotelu vytvořenou z entity.
     * @param hotel Datová entita hotelu
     * @return Instance modelu hotelu
     */
    public static HotelModel getFromEntity(Hotel hotel) {
        return new HotelModel(hotel);
    }

    @Override
    public String getImgPath() {
        return this.imgPath;
    }
}
