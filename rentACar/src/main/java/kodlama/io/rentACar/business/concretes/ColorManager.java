package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ColorService;
import kodlama.io.rentACar.business.requests.colorRequest.CreateColorRequest;
import kodlama.io.rentACar.business.requests.colorRequest.UpdateColorRequest;
import kodlama.io.rentACar.business.responses.colorResponse.GetByIdColorResponse;
import kodlama.io.rentACar.business.responses.colorResponse.GetListColorResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ColorRepository;
import kodlama.io.rentACar.entities.concretes.Color;

@Service
public class ColorManager implements ColorService{
	private ModelMapperService modelMapperService;
	private ColorRepository colorRepository;
	
	@Autowired
	public ColorManager(ModelMapperService modelMapperService, ColorRepository colorRepository) {
		super();
		this.modelMapperService = modelMapperService;
		this.colorRepository = colorRepository;
	}
	@Override
	public List<GetListColorResponse> getAll() {
		List<Color> colors = this.colorRepository.findAll();
		List<GetListColorResponse> listResponse = colors.stream()
				.map(color -> this.modelMapperService.forResponse()
				.map(color,GetListColorResponse.class)).collect(Collectors.toList());
		
		return listResponse;
	}
	@Override
	public GetByIdColorResponse getById(int id) {
		Optional<Color> color = this.colorRepository.findById(id);
		GetByIdColorResponse response = this.modelMapperService.forResponse()
				.map(color.get(), GetByIdColorResponse.class);
		
		return response;
	}
	@Override
	public void add(CreateColorRequest createColorRequest) {
		Color color = this.modelMapperService.forRequest().map(createColorRequest, Color.class);
		
		this.colorRepository.save(color);
		
	}
	@Override
	public void update(UpdateColorRequest updateColorRequest) {
		Color color = this.modelMapperService.forRequest().map(updateColorRequest, Color.class);
		
		this.colorRepository.save(color);
		
	}
	@Override
	public void delete(int id) {
		this.colorRepository.deleteById(id);
		
	}
}
