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

import kodlama.io.rentACar.business.abstracts.FuelService;
import kodlama.io.rentACar.business.requests.fuelRequest.CreateFuelRequest;
import kodlama.io.rentACar.business.requests.fuelRequest.UpdateFuelRequest;
import kodlama.io.rentACar.business.responses.fuelResponse.GetByIdFuelResponse;
import kodlama.io.rentACar.business.responses.fuelResponse.GetListFuelResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/fuels")
public class FuelsController {
	private FuelService fuelService;

	@Autowired
	public FuelsController(FuelService fuelService) {
		super();
		this.fuelService = fuelService;
	}
	
	@GetMapping("/getAll")
	public List<GetListFuelResponse> getAll(){
		return this.fuelService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public GetByIdFuelResponse getById(@PathVariable int id) {
		return this.fuelService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() CreateFuelRequest createFuelRequest) {
		this.fuelService.add(createFuelRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody() UpdateFuelRequest updateFuelRequest) {
		this.fuelService.update(updateFuelRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.fuelService.delete(id);
	}
	
}
