package kodlama.io.rentACar.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.MernisService;
import kodlama.io.rentACar.core.business.helpers.mernis.MernisCheckService;
import kodlama.io.rentACar.core.utilities.results.Result;

@Service
public class MernisManager implements MernisService{
	private MernisCheckService mernisCheckService;
	
	@Autowired
	public MernisManager(MernisCheckService mernisCheckService) {
		super();
		this.mernisCheckService = mernisCheckService;
	}


	@Override
	public Result CheckIfcheckIfRealPerson(String nationalityIdentity,String firstName,String lastName,int dateOfBirthYear) {
		return mernisCheckService.checkIfRealPerson(nationalityIdentity, firstName, lastName, dateOfBirthYear);
	}

}
