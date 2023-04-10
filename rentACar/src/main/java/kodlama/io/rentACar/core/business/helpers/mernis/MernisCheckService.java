package kodlama.io.rentACar.core.business.helpers.mernis;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.entities.concretes.IndividualCustomer;

@Service
public interface MernisCheckService {

	public Result checkIfRealPerson(IndividualCustomer individualCustomer);
}