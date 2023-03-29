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


import kodlama.io.rentACar.business.abstracts.ColorService;
import kodlama.io.rentACar.business.requests.colorRequest.CreateColorRequest;
import kodlama.io.rentACar.business.requests.colorRequest.UpdateColorRequest;
import kodlama.io.rentACar.business.responses.colorResponse.GetByIdColorResponse;
import kodlama.io.rentACar.business.responses.colorResponse.GetListColorResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/colors/")
public class ColorsController {
	private ColorService colorService;

	@Autowired
	public ColorsController(ColorService colorService) {
		super();
		this.colorService = colorService;
	}
	
	@GetMapping("/getAll")
	public List<GetListColorResponse> getAll() {
		return this.colorService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public GetByIdColorResponse getById(@PathVariable int id) {
		return this.colorService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() CreateColorRequest createColorRequest) {
		this.colorService.add(createColorRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody() UpdateColorRequest updateColorRequest) {
		this.colorService.update(updateColorRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.colorService.delete(id);
	}
}
