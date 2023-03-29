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


import kodlama.io.rentACar.business.abstracts.CustomerService;
import kodlama.io.rentACar.business.requests.customerRequest.CreateCustomerRequest;
import kodlama.io.rentACar.business.requests.customerRequest.UpdateCustomerRequest;
import kodlama.io.rentACar.business.responses.customerResposne.GetByIdCustomerResponse;
import kodlama.io.rentACar.business.responses.customerResposne.GetListCustomerResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomersController {
	private CustomerService customerService;

	@Autowired
	public CustomersController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping("/getAll")
	public List<GetListCustomerResponse> getAll(){
		return this.customerService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public GetByIdCustomerResponse getById(@PathVariable int id) {
		return this.customerService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() CreateCustomerRequest createCustomerRequest) {
		this.customerService.add(createCustomerRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody() UpdateCustomerRequest updateCustomerRequest) {
		this.customerService.update(updateCustomerRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.customerService.delete(id);
	}
}
