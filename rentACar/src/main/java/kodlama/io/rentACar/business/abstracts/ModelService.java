package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.modelRequest.CreateModelRequest;
import kodlama.io.rentACar.business.requests.modelRequest.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.modelResponse.GetByIdModelResponse;
import kodlama.io.rentACar.business.responses.modelResponse.GetListModelResponse;

@Service
public interface ModelService {
	List<GetListModelResponse> getAll();
	GetByIdModelResponse getById(int id);
	void add(CreateModelRequest createModelRequest);
	void delete(int id);
	void update(UpdateModelRequest updateModelRequest);
}
