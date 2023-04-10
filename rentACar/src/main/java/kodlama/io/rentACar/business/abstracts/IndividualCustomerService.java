package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.individualCustomerRequest.CreateIndividualCustomerRequest;
import kodlama.io.rentACar.business.requests.individualCustomerRequest.UpdateIndividualCustomerRequest;
import kodlama.io.rentACar.business.responses.individualCustomerResponse.GetByIdIndividualCustomerResponse;
import kodlama.io.rentACar.business.responses.individualCustomerResponse.GetListIndividualCustomerResponse;
@Service
public interface IndividualCustomerService {
	List<GetListIndividualCustomerResponse> getAll();
	GetByIdIndividualCustomerResponse getById(int id);
	void add(CreateIndividualCustomerRequest createIndividualCustomerRequest);
	void update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest);
	void delete(int id);
	GetByIdIndividualCustomerResponse getByUserId(int id);
}
