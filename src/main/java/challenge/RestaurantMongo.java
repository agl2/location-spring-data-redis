package challenge;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Classe para mapear o restaurante no MongoDB
 *
 */
@Document(collection = "restaurants")
public class RestaurantMongo {

    private GeoJsonPoint location;
    private String name;

    public RestaurantMongo() {
    }

    public GeoJsonPoint getLocation() {
        return location;
    }

    public void setLocation(GeoJsonPoint location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
