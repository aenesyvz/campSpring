package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.RentalService;
import kodlama.io.rentACar.business.requests.rentalRequest.CreateRentalRequest;
import kodlama.io.rentACar.business.requests.rentalRequest.UpdateRentalRequest;
import kodlama.io.rentACar.business.responses.rentalResponse.GetByIdRentalResponse;
import kodlama.io.rentACar.business.responses.rentalResponse.GetListRentalResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.RentalRepository;
import kodlama.io.rentACar.entities.concretes.Rental;

@Service
public class RentalManager implements RentalService{
	private ModelMapperService modelMapperService;
	private RentalRepository rentalRepository;
	
	@Autowired
	public RentalManager(ModelMapperService modelMapperService, RentalRepository rentalRepository) {
		super();
		this.modelMapperService = modelMapperService;
		this.rentalRepository = rentalRepository;
	}

	@Override
	public List<GetListRentalResponse> getAll() {
		List<Rental> rentals = this.rentalRepository.findAll();
		List<GetListRentalResponse> listResponse = rentals.stream()
				.map(rental -> this.modelMapperService.forResponse()
						.map(rental, GetListRentalResponse.class)).collect(Collectors.toList());
		
		return listResponse;
	}

	@Override
	public GetByIdRentalResponse getById(int id) {
		Optional<Rental> rental = this.rentalRepository.findById(id);
		GetByIdRentalResponse response = this.modelMapperService.forResponse()
				.map(rental.get(), GetByIdRentalResponse.class);
		
		return response;
	}

	@Override
	public void add(CreateRentalRequest createRentalRequest) {
		Rental rental = this.modelMapperService.forRequest().map(createRentalRequest, Rental.class);
		this.rentalRepository.save(rental);
	}

	@Override
	public void update(UpdateRentalRequest updateRentalRequest) {
		Rental rental = this.modelMapperService.forRequest().map(updateRentalRequest, Rental.class);
		this.rentalRepository.save(rental);
		
	}

	@Override
	public void delete(int id) {
		this.rentalRepository.deleteById(id);
	}
	
}
