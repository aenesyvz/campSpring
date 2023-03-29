package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.customerRequest.CreateCustomerRequest;
import kodlama.io.rentACar.business.requests.customerRequest.UpdateCustomerRequest;
import kodlama.io.rentACar.business.responses.customerResposne.GetByIdCustomerResponse;
import kodlama.io.rentACar.business.responses.customerResposne.GetListCustomerResponse;
@Service
public interface CustomerService {
	List<GetListCustomerResponse> getAll();
	GetByIdCustomerResponse getById(int id);
	void add(CreateCustomerRequest createCustomerRequest);
	void update(UpdateCustomerRequest updateCustomerRequest);
	void delete(int id);
}
