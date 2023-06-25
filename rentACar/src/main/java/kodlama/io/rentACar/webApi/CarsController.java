package kodlama.io.rentACar.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.responses.carResponse.*;
import kodlama.io.rentACar.core.utilities.results.DataResult;
import kodlama.io.rentACar.entities.concretes.Car;
import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.carRequest.*;

@CrossOrigin
@RestController
@RequestMapping("/api/cars")
public class CarsController {
	private CarService carService;
	
	@Autowired
	public CarsController(CarService carService) {
		super();
		this.carService = carService;
	}
	
	@GetMapping("/getList")
	public List<GetListCarResponse> getList(){
		return this.carService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public GetByIdCarResponse getById(@PathVariable int id) {
		return this.carService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public DataResult<Car> add(@RequestBody() CreateCarRequest createCarRequest) {
		return this.carService.add(createCarRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody() UpdateCarRequest updateCarRequest) {
		this.carService.update(updateCarRequest);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.carService.delete(id);
	}
}
