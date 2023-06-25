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

import kodlama.io.rentACar.business.abstracts.StaffService;
import kodlama.io.rentACar.business.requests.staffRequest.CreateStaffRequest;
import kodlama.io.rentACar.business.requests.staffRequest.UpdateStaffRequest;
import kodlama.io.rentACar.business.responses.staffResponse.GetByIdStaffResponse;
import kodlama.io.rentACar.business.responses.staffResponse.GetListStaffResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/staffs")
public class StaffsController {
	StaffService staffService;
	
	@Autowired
	public StaffsController(StaffService staffService) {
		this.staffService = staffService;
	}
	
	@GetMapping("/getAll")
	public List<GetListStaffResponse> getAll(){
		return this.staffService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public GetByIdStaffResponse getById(@PathVariable int id) {
		return this.staffService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code= HttpStatus.CREATED)
	public void add(@RequestBody() CreateStaffRequest createStaffRequest) {
		 this.staffService.add(createStaffRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody() UpdateStaffRequest updateStaffRequest) {
		this.staffService.update(updateStaffRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.staffService.delete(id);
	}
}
