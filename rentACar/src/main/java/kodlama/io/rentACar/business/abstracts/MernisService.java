package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.core.utilities.results.Result;


public interface MernisService {
	Result CheckIfcheckIfRealPerson(String nationalityIdentity,String firstName,String lastName,int dateOfBirthYear);
}
