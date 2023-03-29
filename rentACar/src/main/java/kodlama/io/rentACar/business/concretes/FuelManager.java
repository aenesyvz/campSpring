package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.FuelService;
import kodlama.io.rentACar.business.requests.fuelRequest.CreateFuelRequest;
import kodlama.io.rentACar.business.requests.fuelRequest.UpdateFuelRequest;
import kodlama.io.rentACar.business.responses.fuelResponse.GetByIdFuelResponse;
import kodlama.io.rentACar.business.responses.fuelResponse.GetListFuelResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.FuelRepository;
import kodlama.io.rentACar.entities.concretes.Fuel;

@Service
public class FuelManager implements FuelService{
	private ModelMapperService modelMapperService;
	private FuelRepository fuelRepository;
	
	@Autowired
	public FuelManager(ModelMapperService modelMapperService, FuelRepository fuelRepository) {
		super();
		this.modelMapperService = modelMapperService;
		this.fuelRepository = fuelRepository;
	}

	@Override
	public List<GetListFuelResponse> getAll() {
		List<Fuel> fuels = this.fuelRepository.findAll();
		List<GetListFuelResponse> listResponse = fuels.stream()
				.map(fuel -> this.modelMapperService.forResponse().map(fuel, GetListFuelResponse.class)).collect(Collectors.toList());
		return listResponse;
	}

	@Override
	public GetByIdFuelResponse getById(int id) {
		Optional<Fuel> fuel = this.fuelRepository.findById(id);
		GetByIdFuelResponse response = this.modelMapperService.forResponse().map(fuel.get(), GetByIdFuelResponse.class);
		return response;
	}

	@Override
	public void add(CreateFuelRequest createFuelRequest) {
		Fuel fuel = this.modelMapperService.forRequest().map(createFuelRequest, Fuel.class);
		this.fuelRepository.save(fuel);
	}

	@Override
	public void update(UpdateFuelRequest updateFuelRequest) {
		Fuel fuel = this.modelMapperService.forRequest().map(updateFuelRequest,Fuel.class);
		this.fuelRepository.save(fuel);
	}

	@Override
	public void delete(int id) {
		this.fuelRepository.deleteById(id);
	}
	
	
}
