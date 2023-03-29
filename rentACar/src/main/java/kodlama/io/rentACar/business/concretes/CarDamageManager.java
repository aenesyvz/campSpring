package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.CarDamageService;
import kodlama.io.rentACar.business.requests.carDamageRequest.CreateCarDamageRequest;
import kodlama.io.rentACar.business.requests.carDamageRequest.UpdateCarDamageRequest;
import kodlama.io.rentACar.business.responses.carDamageResponse.GetByIdCarDamageResponse;
import kodlama.io.rentACar.business.responses.carDamageResponse.GetListCarDamageResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CarDamageRepository;
import kodlama.io.rentACar.entities.concretes.CarDamage;

@Service
public class CarDamageManager implements CarDamageService{
	private ModelMapperService modelMapperService;
	private CarDamageRepository cardDamageRepository;
	
	
	@Autowired
	public CarDamageManager(ModelMapperService modelMapperService, CarDamageRepository cardDamageRepository) {
		super();
		this.modelMapperService = modelMapperService;
		this.cardDamageRepository = cardDamageRepository;
	}

	@Override
	public List<GetListCarDamageResponse> getAll() {
		List<CarDamage> carDamages = this.cardDamageRepository.findAll();
		List<GetListCarDamageResponse> listResponse = carDamages.stream()
				.map(carDamage -> this.modelMapperService.forResponse()
				.map(carDamage,GetListCarDamageResponse.class)).collect(Collectors.toList());
				
		return listResponse;
	}

	@Override
	public GetByIdCarDamageResponse getById(int id) {
		Optional<CarDamage> carDamage = this.cardDamageRepository.findById(id);
		GetByIdCarDamageResponse response = this.modelMapperService.forResponse().map(carDamage.get(), GetByIdCarDamageResponse.class);
		
		return response;
	}

	@Override
	public void add(CreateCarDamageRequest createCarDamageRequest) {
		CarDamage carDamage = this.modelMapperService.forRequest().map(createCarDamageRequest,CarDamage.class);
		carDamage.setId(0);
		this.cardDamageRepository.save(carDamage);
		
	}

	@Override
	public void update(UpdateCarDamageRequest updateCarDamageRequest) {
		CarDamage carDamage = this.modelMapperService.forRequest().map(updateCarDamageRequest,CarDamage.class);
		
		this.cardDamageRepository.save(carDamage);
		
		
	}

	@Override
	public void delete(int id) {
		this.cardDamageRepository.deleteById(id);
		
	}

}
