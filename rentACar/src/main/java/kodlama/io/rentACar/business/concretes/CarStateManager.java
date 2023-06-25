package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.CarStateService;
import kodlama.io.rentACar.business.requests.carStateRequest.CreateCarStateRequest;
import kodlama.io.rentACar.business.requests.carStateRequest.UpdateCarStateRequest;
import kodlama.io.rentACar.business.responses.carStateResponse.GetByIdCarStateResponse;
import kodlama.io.rentACar.business.responses.carStateResponse.GetListCarStateResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CarStateRepository;
import kodlama.io.rentACar.entities.concretes.CarState;

@Service
public class CarStateManager implements CarStateService{
	private ModelMapperService modelMapperService;
	private CarStateRepository carStateRepository;
	
	@Autowired
	public CarStateManager(ModelMapperService modelMapperService,CarStateRepository carStateRepository) {
		this.modelMapperService = modelMapperService;
		this.carStateRepository = carStateRepository;
	}
	
	@Override
	public List<GetListCarStateResponse> getAll() {
		List<CarState> carStates = this.carStateRepository.findAll();
		
		List<GetListCarStateResponse> listResponse = carStates.stream()
				.map(carState -> this.modelMapperService.forResponse()
				.map(carState,GetListCarStateResponse.class)).collect(Collectors.toList());
		
		return listResponse;
	}

	@Override
	public GetByIdCarStateResponse getById(int id) {
		Optional<CarState> carState = this.carStateRepository.findById(id);
		GetByIdCarStateResponse response = this.modelMapperService.forResponse().map(carState.get(), GetByIdCarStateResponse.class);
		
		return response;
	}

	@Override
	public void add(CreateCarStateRequest createCarStateRequest) {
		CarState carState = this.modelMapperService.forRequest().map(createCarStateRequest,CarState.class);
		carState.setId(0);
		this.carStateRepository.save(carState);
	}

	@Override
	public void update(UpdateCarStateRequest updateCarStateRequest) {
		CarState carState = this.modelMapperService.forRequest().map(updateCarStateRequest, CarState.class);
		this.carStateRepository.save(carState);
	}

	@Override
	public void delete(int id) {
		this.carStateRepository.deleteById(id);
	}
	
}
