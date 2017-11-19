package prom.jhsmile.com.promapp.model;

/**
 * Created by jhdev on 11-11-17.
 */

public class ProductOfert {
    private String uuid;
    private String title;
    private String imageUrl;
    private String description;
    private String shortDescription;
    private String lat;
    private String lon;
    private String phone;
    private String direction;

    public ProductOfert() {    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLatitud() {
        return lat;
    }

    public void setLatitud(String latitud) {
        this.lat = latitud;
    }

    public String getLongitud() {
        return lon;
    }

    public void setLongitud(String longitud) {
        this.lon = longitud;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
