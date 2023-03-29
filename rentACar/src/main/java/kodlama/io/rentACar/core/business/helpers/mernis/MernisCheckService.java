package kodlama.io.rentACar.core.business.helpers.mernis;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.entities.concretes.IndividualCustomer;

@Service
public interface MernisCheckService {

	public boolean checkIfRealPerson(IndividualCustomer individualCustomer);
}