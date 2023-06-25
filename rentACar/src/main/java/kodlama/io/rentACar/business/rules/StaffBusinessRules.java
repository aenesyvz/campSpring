package kodlama.io.rentACar.business.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.MernisService;
import kodlama.io.rentACar.core.exceptions.BusinessException;
import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.dataAccess.abstracts.StaffRepository;
import kodlama.io.rentACar.entities.concretes.Staff;

@Service
public class StaffBusinessRules {
	private StaffRepository staffRepository;
	private MernisService mernisService;

	@Autowired
	public StaffBusinessRules(
			StaffRepository staffRepository,
			MernisService mernisService) {
		super();
		this.staffRepository = staffRepository;
		this.mernisService = mernisService;
	}
	public void CheckIfRealPerson(Staff staff) {
		Result result = this.mernisService.CheckIfcheckIfRealPerson(
				staff.getNationalityIdentity(),
				staff.getFirstName(),
				staff.getLastName(),
				staff.getDateOfBirth().getYear());
		
		
		if(!result.isSuccess()) {
			throw new BusinessException(result.getMessage());
		}
	}
}
