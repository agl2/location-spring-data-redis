package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restaurants")
public class RestaurantController {

	@Autowired
	private RestaurantService service;

	@RequestMapping("findInNeighborhood/{x}/{y}")
	public NeighborhoodRedis findInNeighborhood(@PathVariable double x, @PathVariable double y) {
		return service.findInNeighborhood(x, y);
	}


	@GetMapping("neighborhood")
	public List<NeighborhoodRedis> findAllCached() {
		return service.findAllCached();
	}
}
