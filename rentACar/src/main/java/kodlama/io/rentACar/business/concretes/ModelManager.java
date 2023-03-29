package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.modelRequest.CreateModelRequest;
import kodlama.io.rentACar.business.requests.modelRequest.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.modelResponse.GetByIdModelResponse;
import kodlama.io.rentACar.business.responses.modelResponse.GetListModelResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
@Service
public class ModelManager implements ModelService{
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public ModelManager(ModelRepository modelRepository, ModelMapperService modelMapperService) {
		super();
		this.modelRepository = modelRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<GetListModelResponse> getAll() {
		List<Model> models = this.modelRepository.findAll();
		List<GetListModelResponse> listBrandResponse = models.stream().
				map(model-> this.modelMapperService.forResponse()
						.map(model, GetListModelResponse.class)).collect(Collectors.toList());
		
		return listBrandResponse;
	}

	@Override
	public GetByIdModelResponse getById(int id) {
		Optional<Model> model = this.modelRepository.findById(id);
		GetByIdModelResponse response = this.modelMapperService.forResponse().map(model.get(), GetByIdModelResponse.class);
		
		return response;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		model.setId(0);
		this.modelRepository.save(model);
	}

	@Override
	public void delete(int id) {
		this.modelRepository.deleteById(id);
		
	}

	@Override
	public void update(UpdateModelRequest updateModelRequest) {
		Model model = this.modelMapperService.forRequest().map(updateModelRequest, Model.class);
		this.modelRepository.save(model);
		
	}
	
	
}
