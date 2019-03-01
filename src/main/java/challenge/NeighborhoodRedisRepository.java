package challenge;

import org.springframework.data.repository.CrudRepository;

public interface NeighborhoodRedisRepository extends CrudRepository<NeighborhoodRedis, String> {

    NeighborhoodRedis findByName(String name);
}
