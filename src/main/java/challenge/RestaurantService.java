package challenge;

import java.util.List;

public interface RestaurantService {
	
	NeighborhoodRedis findInNeighborhood(double x, double y);

    List<NeighborhoodRedis> findAllCached();

    NeighborhoodMongo findInNeighborhoodMongo(double x, double y);

}
