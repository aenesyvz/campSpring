package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ActivationCodeService;
import kodlama.io.rentACar.business.abstracts.EmailService;
import kodlama.io.rentACar.business.abstracts.IndividualCustomerService;
import kodlama.io.rentACar.business.requests.individualCustomerRequest.CreateIndividualCustomerRequest;
import kodlama.io.rentACar.business.requests.individualCustomerRequest.UpdateIndividualCustomerRequest;
import kodlama.io.rentACar.business.responses.individualCustomerResponse.GetByIdIndividualCustomerResponse;
import kodlama.io.rentACar.business.responses.individualCustomerResponse.GetListIndividualCustomerResponse;
import kodlama.io.rentACar.business.rules.IndividualCustomerBusinessRules;
import kodlama.io.rentACar.business.rules.UserBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.IndividualCustomerRepository;
import kodlama.io.rentACar.entities.concretes.IndividualCustomer;

@Service
public class IndividualCustomerManager implements IndividualCustomerService{
	private ModelMapperService modelMapperService;
	private IndividualCustomerRepository individualCustomerRepository;
	private EmailService emailService;
	private ActivationCodeService activationCodeService;
	private IndividualCustomerBusinessRules individualCustomerBusinessRules;
	private UserBusinessRules userBusinessRules;
	@Autowired
	public IndividualCustomerManager(ModelMapperService modelMapperService,
			IndividualCustomerRepository individualCustomerRepository,
			EmailService emailService,
			ActivationCodeService activationCodeService,
			IndividualCustomerBusinessRules individualCustomerBusinessRules,
			UserBusinessRules userBusinessRules) {
		super();
		this.modelMapperService = modelMapperService;
		this.individualCustomerRepository = individualCustomerRepository;
		this.emailService = emailService;
		this.activationCodeService = activationCodeService;
		this.individualCustomerBusinessRules = individualCustomerBusinessRules;
		this.userBusinessRules = userBusinessRules;
	}

	@Override
	public List<GetListIndividualCustomerResponse> getAll() {
		List<IndividualCustomer> individualCustomers = this.individualCustomerRepository.findAll();
		List<GetListIndividualCustomerResponse> listResponses = individualCustomers.stream()
				.map(individualCustomer -> this.modelMapperService.forResponse()
						.map(individualCustomer, GetListIndividualCustomerResponse.class)).collect(Collectors.toList());
		
		return listResponses;
	}

	@Override
	public GetByIdIndividualCustomerResponse getById(int id) {
		Optional<IndividualCustomer> individualCustomer = this.individualCustomerRepository.findById(id);
		GetByIdIndividualCustomerResponse response = this.modelMapperService.forResponse()
				.map(individualCustomer.get(), GetByIdIndividualCustomerResponse.class);
		return response;
	}

	@Override
	public void add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
		this.userBusinessRules.CheckIfEmailExists(createIndividualCustomerRequest.getEmail());
		
		IndividualCustomer individualCustomer = this.modelMapperService.forRequest().map(createIndividualCustomerRequest, IndividualCustomer.class);
		individualCustomer.setId(0);
		individualCustomer.setMailVerify(false);
		individualCustomer.setRole(4);
		individualCustomer.setStatus(true);
		
		this.individualCustomerBusinessRules.CheckIfRealPerson(individualCustomer);
//		Result businessRulesResult = BusinessRules.run(
//				this.mernisService.CheckIfcheckIfRealPerson(individualCustomer)
//				);
//		
//		if(!businessRulesResult.isSuccess()) {
//			return businessRulesResult;
//		}
				
	
		this.individualCustomerRepository.save(individualCustomer);
		this.emailService.sendVerifyEmail(individualCustomer, this.activationCodeService.createActivationCode(individualCustomer));
	}

	@Override
	public void update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
		IndividualCustomer individualCustomer = this.modelMapperService.forRequest().map(updateIndividualCustomerRequest, IndividualCustomer.class);
		this.individualCustomerRepository.save(individualCustomer);
	}

	@Override
	public void delete(int id) {
		this.individualCustomerRepository.deleteById(id);
		
	}

	@Override
	public GetByIdIndividualCustomerResponse getByUserId(int id) {
		Optional<IndividualCustomer> individualCustomer = this.individualCustomerRepository.findById(id);
		GetByIdIndividualCustomerResponse response = this.modelMapperService.forResponse()
				.map(individualCustomer.get(), GetByIdIndividualCustomerResponse.class);
		return response;
	}
	
	
}
