package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.corporateCustomerRequest.CreateCorporateCustomerRequest;
import kodlama.io.rentACar.business.requests.corporateCustomerRequest.UpdateCorporateCustomerRequest;
import kodlama.io.rentACar.business.responses.corporateCustomerResponse.GetByIdCorporateCustomerResponse;
import kodlama.io.rentACar.business.responses.corporateCustomerResponse.GetListCorporateCustomerResponse;
@Service
public interface CorporateCustomerService {
	List<GetListCorporateCustomerResponse> getAll();
	GetByIdCorporateCustomerResponse getById(int id);
	void add(CreateCorporateCustomerRequest createCorporateCustomerRequest);
	void update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest);
	void delete(int id);
}
