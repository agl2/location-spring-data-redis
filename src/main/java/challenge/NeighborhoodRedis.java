package challenge;

import org.springframework.data.redis.core.RedisHash;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe para mapear o bairro no Redis
 *
 */
@RedisHash("Neighborhood")
public class NeighborhoodRedis {

    private String id;
    private String name;
    private List<RestaurantRedis> restaurants;

    public NeighborhoodRedis(){

    }

    public NeighborhoodRedis(NeighborhoodMongo neighborhoodMongo, List<RestaurantMongo> restaurantMongoList) {
        this.name = neighborhoodMongo.getName();
        restaurants = restaurantMongoList.stream().map(RestaurantRedis::new).collect(Collectors.toList());
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

    public List<RestaurantRedis> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantRedis> restaurants) {
        this.restaurants = restaurants;
    }
}
