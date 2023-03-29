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

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.brandRequest.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.brandRequest.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.brandResponse.GetByIdBrandResponse;
import kodlama.io.rentACar.business.responses.brandResponse.GetListBrandResponse;


@CrossOrigin
@RestController
@RequestMapping("/api/brands")
public class BrandsController {
	private BrandService brandService;

	@Autowired
	public BrandsController(BrandService _brandService) {
		super();
		this.brandService = _brandService;
	}
	
	@GetMapping("/getList")
	public List<GetListBrandResponse> getList(){
		return brandService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id) {
		return brandService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() CreateBrandRequest createBrandRequest) {
		brandService.add(createBrandRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody() UpdateBrandRequest updateBrandRequest) {
		brandService.update(updateBrandRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		brandService.delete(id);
	}
	
	
}
