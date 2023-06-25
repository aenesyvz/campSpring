package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.cityRequest.CreateCityRequest;
import kodlama.io.rentACar.business.requests.cityRequest.UpdateCityRequest;
import kodlama.io.rentACar.business.responses.cityResponse.GetByIdCityResponse;
import kodlama.io.rentACar.business.responses.cityResponse.GetListCityResponse;
import kodlama.io.rentACar.business.responses.cityResponse.GetListCityWithDistrictResponse;

@Service
public interface CityService {
	List<GetListCityResponse> GetAll();
	GetByIdCityResponse GetById(int id);
	void Add(CreateCityRequest createCityRequest);
	void Update(UpdateCityRequest updateCityRequest);
	void Delete(int id);
}	
