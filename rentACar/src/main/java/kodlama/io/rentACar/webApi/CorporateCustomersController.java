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

import kodlama.io.rentACar.business.abstracts.CorporateCustomerService;
import kodlama.io.rentACar.business.requests.corporateCustomerRequest.CreateCorporateCustomerRequest;
import kodlama.io.rentACar.business.requests.corporateCustomerRequest.UpdateCorporateCustomerRequest;
import kodlama.io.rentACar.business.responses.corporateCustomerResponse.GetByIdCorporateCustomerResponse;
import kodlama.io.rentACar.business.responses.corporateCustomerResponse.GetListCorporateCustomerResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/corporateCustomers")
public class CorporateCustomersController {
	private CorporateCustomerService corporateCustomerService;

	@Autowired
	public CorporateCustomersController(CorporateCustomerService corporateCustomerService) {
		super();
		this.corporateCustomerService = corporateCustomerService;
	}
	
	@GetMapping("/getAll")
	public List<GetListCorporateCustomerResponse> getAll(){
		return this.corporateCustomerService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public GetByIdCorporateCustomerResponse getById(@PathVariable int id) {
		return this.corporateCustomerService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() CreateCorporateCustomerRequest createCorporateCustomerRequest) {
		this.corporateCustomerService.add(createCorporateCustomerRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody() UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {
		this.corporateCustomerService.update(updateCorporateCustomerRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.corporateCustomerService.delete(id);
	}
}
