package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.rentalRequest.CreateRentalRequest;
import kodlama.io.rentACar.business.requests.rentalRequest.UpdateRentalRequest;
import kodlama.io.rentACar.business.responses.rentalResponse.GetByIdRentalResponse;
import kodlama.io.rentACar.business.responses.rentalResponse.GetListRentalResponse;

@Service
public interface RentalService {
	List<GetListRentalResponse> getAll();
	GetByIdRentalResponse getById(int id);
	void add(CreateRentalRequest createRentalRequest);
	void update(UpdateRentalRequest updateRentalRequest);
	void delete(int id);
}
