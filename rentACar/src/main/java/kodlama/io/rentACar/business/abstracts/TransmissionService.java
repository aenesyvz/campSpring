package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.transmission.CreateTransmissionRequest;
import kodlama.io.rentACar.business.requests.transmission.UpdateTransmissionRequest;
import kodlama.io.rentACar.business.responses.transmissionResponse.GetByIdTransmissionResponse;
import kodlama.io.rentACar.business.responses.transmissionResponse.GetListTransmissionResponse;

@Service
public interface TransmissionService {
	List<GetListTransmissionResponse> getAll();
	GetByIdTransmissionResponse getById(int id);
	void add(CreateTransmissionRequest createTransmissionRequest);
	void update(UpdateTransmissionRequest updateTransmissionRequest);
	void delete(int id);
}
