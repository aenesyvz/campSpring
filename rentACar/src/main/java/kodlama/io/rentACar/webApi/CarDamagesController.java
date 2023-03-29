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


import kodlama.io.rentACar.business.abstracts.CarDamageService;
import kodlama.io.rentACar.business.requests.carDamageRequest.CreateCarDamageRequest;
import kodlama.io.rentACar.business.requests.carDamageRequest.UpdateCarDamageRequest;
import kodlama.io.rentACar.business.responses.carDamageResponse.GetByIdCarDamageResponse;
import kodlama.io.rentACar.business.responses.carDamageResponse.GetListCarDamageResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/carDamages")
public class CarDamagesController {
	private CarDamageService caDamageService;

	@Autowired
	public CarDamagesController(CarDamageService caDamageService) {
		super();
		this.caDamageService = caDamageService;
	}
	
	@GetMapping("/getAll")
	public List<GetListCarDamageResponse> getAll(){
		return this.caDamageService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public GetByIdCarDamageResponse getById(@PathVariable int id) {
		return this.caDamageService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() CreateCarDamageRequest carDamageRequest) {
		this.caDamageService.add(carDamageRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody() UpdateCarDamageRequest carDamageRequest) {
		this.caDamageService.update(carDamageRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.caDamageService.delete(id);
	}
}
