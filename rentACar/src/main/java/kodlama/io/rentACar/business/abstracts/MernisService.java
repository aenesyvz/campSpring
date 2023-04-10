package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.entities.concretes.IndividualCustomer;


public interface MernisService {
	Result CheckIfcheckIfRealPerson(IndividualCustomer individualCustomer);
}
