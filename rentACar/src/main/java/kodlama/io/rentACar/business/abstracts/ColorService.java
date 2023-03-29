package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.colorRequest.CreateColorRequest;
import kodlama.io.rentACar.business.requests.colorRequest.UpdateColorRequest;
import kodlama.io.rentACar.business.responses.colorResponse.GetByIdColorResponse;
import kodlama.io.rentACar.business.responses.colorResponse.GetListColorResponse;
@Service
public interface ColorService {
	List<GetListColorResponse> getAll();
	GetByIdColorResponse getById(int id);
	void add(CreateColorRequest createColorRequest);
	void update(UpdateColorRequest updateColorRequest);
	void delete(int id);
}
