package challenge;

import java.util.UUID;

/**
 * Classe para mapear o restaurante no Redis
 *
 */
public class RestaurantRedis {
    private String id;
    private String name;
    private double x;
    private double y;

    public RestaurantRedis() {
    }

    public RestaurantRedis(RestaurantMongo restaurantMongo) {
        this.id = UUID.randomUUID().toString();
        this.name = restaurantMongo.getName();
        this.x = restaurantMongo.getLocation().getX();
        this.y = restaurantMongo.getLocation().getY();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
