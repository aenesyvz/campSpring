package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.CustomerService;
import kodlama.io.rentACar.business.requests.customerRequest.CreateCustomerRequest;
import kodlama.io.rentACar.business.requests.customerRequest.UpdateCustomerRequest;
import kodlama.io.rentACar.business.responses.customerResposne.GetByIdCustomerResponse;
import kodlama.io.rentACar.business.responses.customerResposne.GetListCustomerResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CustomerRepository;
import kodlama.io.rentACar.entities.concretes.Customer;

@Service
public class CustomerManager implements CustomerService{
	private ModelMapperService modeMapperService;
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerManager(ModelMapperService modeMapperService, CustomerRepository customerRepository) {
		super();
		this.modeMapperService = modeMapperService;
		this.customerRepository = customerRepository;
	}

	@Override
	public List<GetListCustomerResponse> getAll() {
		List<Customer> customers = this.customerRepository.findAll();
		List<GetListCustomerResponse> listResponse = customers.stream()
				.map(customer -> this.modeMapperService.forResponse()
				.map(customer, GetListCustomerResponse.class)).collect(Collectors.toList());
		
		return listResponse;
	}

	@Override
	public GetByIdCustomerResponse getById(int id) {
		Optional<Customer> customer = this.customerRepository.findById(id);
		GetByIdCustomerResponse response = this.modeMapperService.forResponse()
				.map(customer.get(), GetByIdCustomerResponse.class);
		
		return response;
	}

	@Override
	public void add(CreateCustomerRequest createCustomerRequest) {
		Customer customer = this.modeMapperService.forRequest().map(createCustomerRequest, Customer.class);
		this.customerRepository.save(customer);
	}

	@Override
	public void update(UpdateCustomerRequest updateCustomerRequest) {
		Customer customer = this.modeMapperService.forRequest().map(updateCustomerRequest, Customer.class);
		this.customerRepository.save(customer);
	}

	@Override
	public void delete(int id) {
		this.customerRepository.deleteById(id);
		
	}
}
