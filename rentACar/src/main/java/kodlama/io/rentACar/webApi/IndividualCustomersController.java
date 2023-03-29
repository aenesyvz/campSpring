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

import kodlama.io.rentACar.business.abstracts.IndividualCustomerService;
import kodlama.io.rentACar.business.requests.individualCustomerRequest.CreateIndividualCustomerRequest;
import kodlama.io.rentACar.business.requests.individualCustomerRequest.UpdateIndividualCustomerRequest;
import kodlama.io.rentACar.business.responses.individualCustomerResponse.GetByIdIndividualCustomerResponse;
import kodlama.io.rentACar.business.responses.individualCustomerResponse.GetListIndividualCustomerResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/individualCustomers")
public class IndividualCustomersController {
	private IndividualCustomerService individualCustomerService;

	@Autowired
	public IndividualCustomersController(IndividualCustomerService individualCustomerService) {
		super();
		this.individualCustomerService = individualCustomerService;
	}
	
	@GetMapping("/getAll")
	public List<GetListIndividualCustomerResponse> getAll(){
		return this.individualCustomerService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public GetByIdIndividualCustomerResponse getById(@PathVariable int id) {
		return this.individualCustomerService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code= HttpStatus.CREATED)
	public void add(@RequestBody() CreateIndividualCustomerRequest createIndividualCustomerRequest) {
		this.individualCustomerService.add(createIndividualCustomerRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody() UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
		this.individualCustomerService.update(updateIndividualCustomerRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.individualCustomerService.delete(id);
	}
}
