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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.CarStateService;
import kodlama.io.rentACar.business.requests.carStateRequest.CreateCarStateRequest;
import kodlama.io.rentACar.business.requests.carStateRequest.UpdateCarStateRequest;
import kodlama.io.rentACar.business.responses.carStateResponse.GetByIdCarStateResponse;
import kodlama.io.rentACar.business.responses.carStateResponse.GetListCarStateResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/carState")
public class CarStateController {
	private CarStateService carStateService;
	
	@Autowired
	public CarStateController(CarStateService carStateService) {
		this.carStateService = carStateService;
	}
	
	@GetMapping("/getAll")
	public List<GetListCarStateResponse> getList(){
		return this.carStateService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public GetByIdCarStateResponse getById(int id) {
		return this.carStateService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(CreateCarStateRequest createCarStateRequest) {
		this.carStateService.add(createCarStateRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateCarStateRequest updateCarStateRequest) {
		this.carStateService.update(updateCarStateRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.carStateService.delete(id);
	}
}
