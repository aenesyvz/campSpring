package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.carDamageRequest.CreateCarDamageRequest;
import kodlama.io.rentACar.business.requests.carDamageRequest.UpdateCarDamageRequest;
import kodlama.io.rentACar.business.responses.carDamageResponse.GetByIdCarDamageResponse;
import kodlama.io.rentACar.business.responses.carDamageResponse.GetListCarDamageResponse;
@Service
public interface CarDamageService {
	List<GetListCarDamageResponse> getAll();
	GetByIdCarDamageResponse getById(int id);
	void add(CreateCarDamageRequest createCarDamageRequest);
	void update(UpdateCarDamageRequest updateCarDamageRequest);
	void delete(int id);
}
