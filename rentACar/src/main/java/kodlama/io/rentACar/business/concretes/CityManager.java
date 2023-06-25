package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.CityService;
import kodlama.io.rentACar.business.abstracts.DistrictService;
import kodlama.io.rentACar.business.requests.cityRequest.CreateCityRequest;
import kodlama.io.rentACar.business.requests.cityRequest.UpdateCityRequest;
import kodlama.io.rentACar.business.responses.cityResponse.GetByIdCityResponse;
import kodlama.io.rentACar.business.responses.cityResponse.GetListCityResponse;
import kodlama.io.rentACar.business.responses.districtResponse.GetListDistrictResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CityRepository;
import kodlama.io.rentACar.entities.concretes.City;

@Service
public class CityManager implements CityService{
	private ModelMapperService modelMapperService;
	private CityRepository cityRepository;
	private DistrictService districtService;
	
	@Autowired
	public CityManager(ModelMapperService modelMapperService,CityRepository cityRepository,DistrictService districtService) {
		this.modelMapperService = modelMapperService;
		this.cityRepository = cityRepository;
		this.districtService = districtService;
	}
	@Override
	public List<GetListCityResponse> GetAll() {
		List<City> cities =  this.cityRepository.findAll();
		List<GetListCityResponse> listResponse = cities.stream()
				.map(city -> this.modelMapperService.forResponse().
						map(city, GetListCityResponse.class)).collect(Collectors.toList());
		return listResponse;
	}

	@Override
	public GetByIdCityResponse GetById(int id) {
		Optional<City> city = this.cityRepository.findById(id);
		GetByIdCityResponse response = this.modelMapperService.forResponse().map(city.get(),GetByIdCityResponse.class);
		
		List<GetListDistrictResponse> districts = this.districtService.getAll(id);
		response.setDistricts(districts);
		return response;
	}

	@Override
	public void Add(CreateCityRequest createCityRequest) {
		City city = this.modelMapperService.forRequest().map(createCityRequest, City.class);
		city.setId(0);
		this.cityRepository.save(city);
	}

	@Override
	public void Update(UpdateCityRequest updateCityRequest) {
		City city = this.modelMapperService.forRequest().map(updateCityRequest, City.class);
		this.cityRepository.save(city);
	}

	@Override
	public void Delete(int id) {
		this.cityRepository.deleteById(id);
		
	}

}
