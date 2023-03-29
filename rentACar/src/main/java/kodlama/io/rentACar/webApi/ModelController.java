package kodlama.io.rentACar.webApi;

import java.util.List;

import javax.validation.Valid;

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

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.modelRequest.*;
import kodlama.io.rentACar.business.responses.modelResponse.*;

@CrossOrigin
@RestController
@RequestMapping("/api/models")
public class ModelController {
	private ModelService modelService;

	@Autowired
	public ModelController(ModelService modelService) {
		super();
		this.modelService = modelService;
	}
	
	@GetMapping("/getAll")
	public List<GetListModelResponse> getAll(){
		return this.modelService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public GetByIdModelResponse getById(@PathVariable int id) {
		return this.modelService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateModelRequest createModelRequest) {
		this.modelService.add(createModelRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody() UpdateModelRequest updateModelRequest) {
		this.modelService.update(updateModelRequest);
	}
	
	@DeleteMapping
	public void delete(@PathVariable int id) {
		this.modelService.delete(id);
	}
	
}
