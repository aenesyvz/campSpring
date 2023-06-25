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

import kodlama.io.rentACar.business.abstracts.CityService;
import kodlama.io.rentACar.business.requests.cityRequest.CreateCityRequest;
import kodlama.io.rentACar.business.requests.cityRequest.UpdateCityRequest;
import kodlama.io.rentACar.business.responses.cityResponse.GetByIdCityResponse;
import kodlama.io.rentACar.business.responses.cityResponse.GetListCityResponse;
import kodlama.io.rentACar.business.responses.cityResponse.GetListCityWithDistrictResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/city")
public class CityController {
	private CityService cityService;
	
	@Autowired
	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("/getAll")
	public List<GetListCityResponse> getAll(){
		return this.cityService.GetAll();
	}
	
	
	
	@GetMapping("/getById/{id}")
	public GetByIdCityResponse getById(@PathVariable int id){
		return this.cityService.GetById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(CreateCityRequest createCityRequest) {
		this.cityService.Add(createCityRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateCityRequest updateCityRequest) {
		this.cityService.Update(updateCityRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.cityService.Delete(id);
	}
}
