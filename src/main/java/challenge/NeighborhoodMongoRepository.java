package challenge;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface NeighborhoodMongoRepository extends MongoRepository<NeighborhoodMongo, String> {

    @Query( "{ " +
            "   geometry: {" +
            "     $geoIntersects: {" +
            "        $geometry: ?0" +
            "      }" +
            "  }" +
            "}")
    NeighborhoodMongo findByGeometryIntersects(GeoJsonPoint point);
}
