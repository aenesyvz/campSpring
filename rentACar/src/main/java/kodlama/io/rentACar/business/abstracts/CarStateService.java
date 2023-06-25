package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.carStateRequest.CreateCarStateRequest;
import kodlama.io.rentACar.business.requests.carStateRequest.UpdateCarStateRequest;
import kodlama.io.rentACar.business.responses.carStateResponse.GetByIdCarStateResponse;
import kodlama.io.rentACar.business.responses.carStateResponse.GetListCarStateResponse;

@Service
public interface CarStateService {
	List<GetListCarStateResponse> getAll();
	GetByIdCarStateResponse getById(int id);
	void add(CreateCarStateRequest createCarStateRequest);
	void update(UpdateCarStateRequest updateCarStateRequest);
	void delete(int id);
}
