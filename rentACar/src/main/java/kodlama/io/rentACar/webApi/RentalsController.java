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

import kodlama.io.rentACar.business.abstracts.RentalService;
import kodlama.io.rentACar.business.requests.rentalRequest.CreateRentalRequest;
import kodlama.io.rentACar.business.requests.rentalRequest.UpdateRentalRequest;
import kodlama.io.rentACar.business.responses.rentalResponse.GetByIdRentalResponse;
import kodlama.io.rentACar.business.responses.rentalResponse.GetListRentalResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/rentals")
public class RentalsController {
	private RentalService rentalService;

	@Autowired
	public RentalsController(RentalService rentalService) {
		super();
		this.rentalService = rentalService;
	}
	
	@GetMapping("/getAll")
	public List<GetListRentalResponse> getAll(){
		return this.rentalService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public GetByIdRentalResponse getById(@PathVariable int id) {
		return this.rentalService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() CreateRentalRequest createRentalRequest) {
		this.rentalService.add(createRentalRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody() UpdateRentalRequest updateRentalRequest) {
		this.rentalService.update(updateRentalRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.rentalService.delete(id);
	}
}
