package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.brandRequest.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.brandRequest.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.brandResponse.GetByIdBrandResponse;
import kodlama.io.rentACar.business.responses.brandResponse.GetListBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;

@Service
public class BrandManager implements BrandService{
	private ModelMapperService modelMapperService;
	private BrandRepository brandRepository;
	private BrandBusinessRules brandBusinessRules;
	
	@Autowired
	public BrandManager(BrandRepository _brandRepository,ModelMapperService _modelMapperService,BrandBusinessRules brandBusinessRules) {
		super();
		this.brandRepository = _brandRepository;
		this.modelMapperService = _modelMapperService;
		this.brandBusinessRules = brandBusinessRules;
	}

	@Override
	public List<GetListBrandResponse> getAll() {
		List<Brand> brands = this.brandRepository.findAll();
		List<GetListBrandResponse> listBrandResponse = brands.stream().
				map(brand-> this.modelMapperService.forResponse()
						.map(brand, GetListBrandResponse.class)).collect(Collectors.toList());
		
		return listBrandResponse;
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Optional<Brand> brand = this.brandRepository.findById(id);
		GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		
		return response;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		this.brandBusinessRules.CheckIfBrandNameExists(createBrandRequest.getName());
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
	    this.brandRepository.save(brand);
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);
	}

	
}
