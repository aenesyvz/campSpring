package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.DistrictService;
import kodlama.io.rentACar.business.requests.districtRequest.CreateDistrictRequest;
import kodlama.io.rentACar.business.requests.districtRequest.UpdateDistrcitRequest;
import kodlama.io.rentACar.business.responses.districtResponse.GetByIdDistrictResponse;
import kodlama.io.rentACar.business.responses.districtResponse.GetListDistrictResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.DistrictRepository;
import kodlama.io.rentACar.entities.concretes.District;

@Service
public class DistrictManager implements DistrictService{
	private ModelMapperService modelMapperService;
	private DistrictRepository districtRepository;
	
	
	@Autowired
	public DistrictManager(ModelMapperService modelMapperService,DistrictRepository districtRepository) {
		this.modelMapperService = modelMapperService;
		this.districtRepository = districtRepository;
	}

	@Override
	public List<GetListDistrictResponse> getAll(int id) {
		List<District> districts = this.districtRepository.findAllByCityId(id);
		List<GetListDistrictResponse> listResponse = districts.stream()
				.map(district -> this.modelMapperService.forResponse()
				.map(district, GetListDistrictResponse.class)).collect(Collectors.toList());
		
		return listResponse;
	}

	@Override
	public GetByIdDistrictResponse getByCityId(int cityId) {
		Optional<District> district = this.districtRepository.findById(cityId);
		GetByIdDistrictResponse response = this.modelMapperService.forResponse().map(district, GetByIdDistrictResponse.class);
		
		return response;
	}

	@Override
	public void Add(CreateDistrictRequest createDistrictRequest) {
		District district = this.modelMapperService.forRequest().map(createDistrictRequest, District.class);
		district.setId(0);
		this.districtRepository.save(district);
	}

	@Override
	public void Update(UpdateDistrcitRequest updateDistrcitRequest) {
		District district = this.modelMapperService.forRequest().map(updateDistrcitRequest,District.class);
		this.districtRepository.save(district);
	}

	@Override
	public void Delete(int id) {
		this.districtRepository.deleteById(id);
	}
}
