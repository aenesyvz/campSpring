package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.entities.concretes.IndividualCustomer;


public interface MernisService {
	boolean CheckIfcheckIfRealPerson(IndividualCustomer individualCustomer);
}
