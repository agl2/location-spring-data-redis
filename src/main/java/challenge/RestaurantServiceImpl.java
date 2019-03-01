package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	NeighborhoodMongoRepository neighborhoodMongoRepository;
	@Autowired
	RestaurantMongoRepository restaurantMongoRepository;
	@Autowired
	NeighborhoodRedisRepository neighborhoodRedisRepository;

	@Override
	public NeighborhoodRedis findInNeighborhood(double x, double y) {
		NeighborhoodMongo neighborhoodMongo = neighborhoodMongoRepository.findByGeometryIntersects(new GeoJsonPoint(x, y));
		NeighborhoodRedis neighborhoodRedis = neighborhoodRedisRepository.findByName(neighborhoodMongo.getName());

		if(neighborhoodRedis == null) {
			List<RestaurantMongo> restaurantMongosList = restaurantMongoRepository.findByLocationWithinOrderByNameAsc(neighborhoodMongo.getGeometry());
			neighborhoodRedis = new NeighborhoodRedis(neighborhoodMongo, restaurantMongosList);
			neighborhoodRedisRepository.save(neighborhoodRedis);
		}

		return neighborhoodRedis;
	}

	@Override
	public List<NeighborhoodRedis> findAllCached() {
		List<NeighborhoodRedis> neighborhoodRedisList = new ArrayList<>();
		neighborhoodRedisRepository.findAll().forEach(neighborhoodRedis -> neighborhoodRedisList.add(neighborhoodRedis));
		return neighborhoodRedisList;
	}

	@Override
	public NeighborhoodMongo findInNeighborhoodMongo(double x, double y) {
		GeoJsonPoint geoJsonPoint = new GeoJsonPoint(x, y);
		NeighborhoodMongo neighborhoodMongo = neighborhoodMongoRepository.findByGeometryIntersects(geoJsonPoint);
		return neighborhoodMongo;
	}


}
