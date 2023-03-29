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

import kodlama.io.rentACar.business.abstracts.TransmissionService;
import kodlama.io.rentACar.business.requests.transmission.CreateTransmissionRequest;
import kodlama.io.rentACar.business.requests.transmission.UpdateTransmissionRequest;
import kodlama.io.rentACar.business.responses.transmissionResponse.GetByIdTransmissionResponse;
import kodlama.io.rentACar.business.responses.transmissionResponse.GetListTransmissionResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/transmissions")
public class TransmissionsController {

	private TransmissionService transmissionService;

	@Autowired
	public TransmissionsController(TransmissionService transmissionService) {
		super();
		this.transmissionService = transmissionService;
	}
	
	
	@GetMapping("/getAll")
	public List<GetListTransmissionResponse> getAll(){
		return this.transmissionService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public GetByIdTransmissionResponse getById(@PathVariable int id) {
		return this.transmissionService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() CreateTransmissionRequest createTransmissionRequest) {
		this.transmissionService.add(createTransmissionRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody() UpdateTransmissionRequest  updateTransmissionRequest) {
		this.transmissionService.update(updateTransmissionRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.transmissionService.delete(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
