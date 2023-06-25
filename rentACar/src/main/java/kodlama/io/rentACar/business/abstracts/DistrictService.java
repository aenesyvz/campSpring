package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.districtRequest.CreateDistrictRequest;
import kodlama.io.rentACar.business.requests.districtRequest.UpdateDistrcitRequest;
import kodlama.io.rentACar.business.responses.districtResponse.GetByIdDistrictResponse;
import kodlama.io.rentACar.business.responses.districtResponse.GetListDistrictResponse;

@Service
public interface DistrictService {
	List<GetListDistrictResponse> getAll(int id);
	GetByIdDistrictResponse getByCityId(int cityId);
	void Add(CreateDistrictRequest createDistrictRequest);
	void Update(UpdateDistrcitRequest updateDistrcitRequest);
	void Delete(int id);
	
}
