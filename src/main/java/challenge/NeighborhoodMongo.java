package challenge;

import org.springframework.data.mongodb.core.geo.GeoJsonPolygon;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Classe para mapear o bairro no MongoDB
 *
 */
@Document(collection = "neighborhoods")
public class NeighborhoodMongo {

    private GeoJsonPolygon geometry;
    private String name;

    public NeighborhoodMongo() {
    }

    public GeoJsonPolygon getGeometry() {
        return geometry;
    }

    public void setGeometry(GeoJsonPolygon geometry) {
        this.geometry = geometry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
