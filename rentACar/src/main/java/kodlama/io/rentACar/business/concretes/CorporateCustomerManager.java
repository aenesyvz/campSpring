package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ActivationCodeService;
import kodlama.io.rentACar.business.abstracts.CorporateCustomerService;
import kodlama.io.rentACar.business.abstracts.EmailService;
import kodlama.io.rentACar.business.requests.corporateCustomerRequest.CreateCorporateCustomerRequest;
import kodlama.io.rentACar.business.requests.corporateCustomerRequest.UpdateCorporateCustomerRequest;
import kodlama.io.rentACar.business.responses.corporateCustomerResponse.GetByIdCorporateCustomerResponse;
import kodlama.io.rentACar.business.responses.corporateCustomerResponse.GetListCorporateCustomerResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CorporateCustomerRepository;
import kodlama.io.rentACar.entities.concretes.CorporateCustomer;

@Service
public class CorporateCustomerManager implements CorporateCustomerService{
	private ModelMapperService modelMapperService;
	private CorporateCustomerRepository corporateCustomerRepository;
	private EmailService emailService;
	private ActivationCodeService activationCodeService;
	@Autowired
	public CorporateCustomerManager(ModelMapperService modelMapperService,
			CorporateCustomerRepository corporateCustomerRepository,
			EmailService emailService,ActivationCodeService activationCodeService) {
		super();
		this.modelMapperService = modelMapperService;
		this.corporateCustomerRepository = corporateCustomerRepository;
		this.emailService = emailService;
		this.activationCodeService = activationCodeService;
	}

	@Override
	public List<GetListCorporateCustomerResponse> getAll() {
		List<CorporateCustomer> corporateCustomers = this.corporateCustomerRepository.findAll();
		List<GetListCorporateCustomerResponse> listResponse = corporateCustomers.stream()
				.map(corporateCustomer -> this.modelMapperService.forResponse()
				.map(corporateCustomer, GetListCorporateCustomerResponse.class)).collect(Collectors.toList());
		
		return listResponse;
	}

	@Override
	public GetByIdCorporateCustomerResponse getById(int id) {
		Optional<CorporateCustomer> corporateCustomer = this.corporateCustomerRepository.findById(id);
		GetByIdCorporateCustomerResponse response = this.modelMapperService.forResponse()
				.map(corporateCustomer.get(), GetByIdCorporateCustomerResponse.class);
		
		return response;
	}

	@Override
	public void add(CreateCorporateCustomerRequest createCorporateCustomerRequest) {
		CorporateCustomer corporateCustomer = this.modelMapperService.forRequest().map(createCorporateCustomerRequest, CorporateCustomer.class);
		corporateCustomer.setId(0);
		corporateCustomer.setMailVerify(false);
		corporateCustomer.setVerificationStatus(false);
		corporateCustomer.setStatus(false);
		corporateCustomer.setRole(3);
		
		this.corporateCustomerRepository.save(corporateCustomer);
		
		this.emailService.sendVerifyEmail(corporateCustomer, this.activationCodeService.createActivationCode(corporateCustomer));
	}

	@Override
	public void update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {
		CorporateCustomer corporateCustomer = this.modelMapperService.forRequest().map(updateCorporateCustomerRequest, CorporateCustomer.class);
		this.corporateCustomerRepository.save(corporateCustomer);
	}

	@Override
	public void delete(int id) {
		this.corporateCustomerRepository.deleteById(id);
		
	}
}
