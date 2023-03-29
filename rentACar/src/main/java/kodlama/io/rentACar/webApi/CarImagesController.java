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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.rentACar.business.abstracts.CarImageService;
import kodlama.io.rentACar.business.requests.carImageRequest.UpdateCarImageRequest;
import kodlama.io.rentACar.business.responses.carImageResponse.GetByIdCarImageResponse;
import kodlama.io.rentACar.business.responses.carImageResponse.GetListCarImageResponse;
import kodlama.io.rentACar.entities.concretes.Car;
import kodlama.io.rentACar.entities.concretes.CarImage;

@CrossOrigin
@RestController
@RequestMapping("/api/carImages")
public class CarImagesController {
	private CarImageService carImageService;

	@Autowired
	public CarImagesController(CarImageService carImageService) {
		super();
		this.carImageService = carImageService;
	}
	
	@GetMapping("/getList")
	public List<GetListCarImageResponse> getList(){
		return this.carImageService.getList();
	}
	
	@GetMapping("/getById/{id}")
	public GetByIdCarImageResponse getById(int id) {
		return this.carImageService.getById(id);
	}
	
	@GetMapping("/getByCarId/{id}")
	public  List<CarImage> getByCarId(int carId) {
		return this.carImageService.getListByCarId(carId);
	}
	
	@PostMapping(value="/add",consumes = {
		      "multipart/form-data"
	   })
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestParam() int carId,@RequestBody MultipartFile file) {
		this.carImageService.add(CarImage.builder().car(Car.builder().id(carId).build()).build(),file);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody() UpdateCarImageRequest updateCarImageRequest) {
		this.carImageService.update(updateCarImageRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.carImageService.delete(id);
	}
}
