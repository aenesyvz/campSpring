package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.TransmissionService;
import kodlama.io.rentACar.business.requests.transmission.CreateTransmissionRequest;
import kodlama.io.rentACar.business.requests.transmission.UpdateTransmissionRequest;
import kodlama.io.rentACar.business.responses.transmissionResponse.GetByIdTransmissionResponse;
import kodlama.io.rentACar.business.responses.transmissionResponse.GetListTransmissionResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.TransmissionRepository;
import kodlama.io.rentACar.entities.concretes.Transmission;

@Service
public class TransmissionManager implements TransmissionService{
	private ModelMapperService modelMapperService;
	private TransmissionRepository transmissionRepository;
	
	@Autowired
	public TransmissionManager(ModelMapperService modelMapperService, TransmissionRepository transmissionRepository) {
		super();
		this.modelMapperService = modelMapperService;
		this.transmissionRepository = transmissionRepository;
	}

	@Override
	public List<GetListTransmissionResponse> getAll() {
		List<Transmission> transmissions = this.transmissionRepository.findAll();
		List<GetListTransmissionResponse> lisResponse = transmissions.stream()
				.map(transmission -> this.modelMapperService.forResponse()
						.map(transmission, GetListTransmissionResponse.class)).collect(Collectors.toList());
		return lisResponse;
	}

	@Override
	public GetByIdTransmissionResponse getById(int id) {
		Optional<Transmission> transmission = this.transmissionRepository.findById(id);
		GetByIdTransmissionResponse response = this.modelMapperService.forResponse()
				.map(transmission.get(), GetByIdTransmissionResponse.class);
				
		return response;
	}

	@Override
	public void add(CreateTransmissionRequest createTransmissionRequest) {
		Transmission transmission = this.modelMapperService.forRequest().map(createTransmissionRequest, Transmission.class);
		this.transmissionRepository.save(transmission);
		
	}

	@Override
	public void update(UpdateTransmissionRequest updateTransmissionRequest) {
		Transmission transmission = this.modelMapperService.forRequest().map(updateTransmissionRequest, Transmission.class);
		this.transmissionRepository.save(transmission);
	}

	@Override
	public void delete(int id) {
		this.transmissionRepository.deleteById(id);
		
	}
}
