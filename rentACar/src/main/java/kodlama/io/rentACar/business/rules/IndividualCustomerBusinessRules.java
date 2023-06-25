package kodlama.io.rentACar.business.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.MernisService;
import kodlama.io.rentACar.core.exceptions.BusinessException;
import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.dataAccess.abstracts.IndividualCustomerRepository;
import kodlama.io.rentACar.entities.concretes.IndividualCustomer;

@Service
public class IndividualCustomerBusinessRules {
	private IndividualCustomerRepository individualCustomerRepository;
	private MernisService mernisService;

	@Autowired
	public IndividualCustomerBusinessRules(
			IndividualCustomerRepository individualCustomerRepository,
			MernisService mernisService) {
		super();
		this.individualCustomerRepository = individualCustomerRepository;
		this.mernisService = mernisService;
	}
	public void CheckIfRealPerson(IndividualCustomer individualCustomer) {
		Result result = this.mernisService.CheckIfcheckIfRealPerson(individualCustomer.getNationalityIdentity(),individualCustomer.getFirstName(),individualCustomer.getLastName(),individualCustomer.getDateOfBirth().getYear());
		
		if(!result.isSuccess()) {
			throw new BusinessException(result.getMessage());
		}
	}
	
}
