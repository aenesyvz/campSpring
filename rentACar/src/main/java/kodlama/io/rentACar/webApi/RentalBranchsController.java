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

import kodlama.io.rentACar.business.abstracts.RentalBranchService;
import kodlama.io.rentACar.business.requests.rentalBranchRequest.CreateRentalBranchRequest;
import kodlama.io.rentACar.business.requests.rentalBranchRequest.UpdateRentalBranchRequest;
import kodlama.io.rentACar.business.responses.rentalBranchResponse.GetByIdRentalBranchResponse;
import kodlama.io.rentACar.business.responses.rentalBranchResponse.GetListRentalBranchResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/rentalBranch")
public class RentalBranchsController {
	private RentalBranchService rentalBranchService;

	@Autowired
	public RentalBranchsController(RentalBranchService rentalBranchService) {
		super();
		this.rentalBranchService = rentalBranchService;
	}
	
	
	@GetMapping("/getAll")
	public List<GetListRentalBranchResponse> getAll(){
		return this.rentalBranchService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public GetByIdRentalBranchResponse getById(@PathVariable int id) {
		return this.rentalBranchService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() CreateRentalBranchRequest createRentalBranchRequest) {
		this.rentalBranchService.add(createRentalBranchRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody() UpdateRentalBranchRequest updateRentalBranchRequest) {
		this.rentalBranchService.update(updateRentalBranchRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.rentalBranchService.delete(id);
	}
}
