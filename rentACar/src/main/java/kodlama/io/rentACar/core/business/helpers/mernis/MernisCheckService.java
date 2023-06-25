package kodlama.io.rentACar.core.business.helpers.mernis;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilities.results.Result;

@Service
public interface MernisCheckService {

	public Result checkIfRealPerson(String nationalityIdentity,String firstName,String lastName,int dateOfBirthYear );
}