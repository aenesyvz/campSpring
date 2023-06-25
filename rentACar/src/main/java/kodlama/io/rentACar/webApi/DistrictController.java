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

import kodlama.io.rentACar.business.abstracts.DistrictService;
import kodlama.io.rentACar.business.requests.districtRequest.CreateDistrictRequest;
import kodlama.io.rentACar.business.requests.districtRequest.UpdateDistrcitRequest;
import kodlama.io.rentACar.business.responses.districtResponse.GetByIdDistrictResponse;
import kodlama.io.rentACar.business.responses.districtResponse.GetListDistrictResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/district")
public class DistrictController {
	private DistrictService districtService;
	
	@Autowired
	public DistrictController(DistrictService districtService) {
		super();
		this.districtService = districtService;
	}
	
	@GetMapping("/getAll/{cityId}")
	public List<GetListDistrictResponse> getAll(@PathVariable int cityId){
		return this.districtService.getAll(cityId);
	}
	
	@GetMapping("/getById/{cityId}")
	public GetByIdDistrictResponse getByCityId(@PathVariable int cityId) {
		return this.districtService.getByCityId(cityId);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void Add(CreateDistrictRequest createDistrictRequest) {
		this.districtService.Add(createDistrictRequest);
	}
	
	@PutMapping("/update")
	public void Update(UpdateDistrcitRequest updateDistrcitRequest) {
		this.districtService.Update(updateDistrcitRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void Delete(@PathVariable int id) {
		this.districtService.Delete(id);
	}
}
