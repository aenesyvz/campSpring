package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.fuelRequest.CreateFuelRequest;
import kodlama.io.rentACar.business.requests.fuelRequest.UpdateFuelRequest;
import kodlama.io.rentACar.business.responses.fuelResponse.GetByIdFuelResponse;
import kodlama.io.rentACar.business.responses.fuelResponse.GetListFuelResponse;

@Service
public interface FuelService {
	List<GetListFuelResponse> getAll();
	GetByIdFuelResponse getById(int id);
	void add(CreateFuelRequest createFuelRequest);
	void update(UpdateFuelRequest updateFuelRequest);
	void delete(int id);
}
