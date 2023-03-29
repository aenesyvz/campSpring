package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.carRequest.CreateCarRequest;
import kodlama.io.rentACar.business.requests.carRequest.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.carResponse.GetByIdCarResponse;
import kodlama.io.rentACar.business.responses.carResponse.GetListCarResponse;

@Service
public interface CarService {
	List<GetListCarResponse> getAll();
	GetByIdCarResponse getById(int id);
	void add(CreateCarRequest createCarRequest);
	void update(UpdateCarRequest updateCarRequest);
	void delete(int id);
}
