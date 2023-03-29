package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.brandRequest.*;
import kodlama.io.rentACar.business.responses.brandResponse.GetByIdBrandResponse;
import kodlama.io.rentACar.business.responses.brandResponse.GetListBrandResponse;


@Service
public interface BrandService {
	List<GetListBrandResponse> getAll();
	GetByIdBrandResponse getById(int id);
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);
}
