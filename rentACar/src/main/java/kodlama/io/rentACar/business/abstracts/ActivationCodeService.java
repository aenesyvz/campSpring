package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.core.entities.User;
import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.entities.concretes.ActivationCode;

public interface ActivationCodeService {
	ActivationCode getByCode(String code);
	String createActivationCode(User user);
	boolean activationUser(String code);
	Result confirmUserEmailForResetPassword(String email,String code);
	String createConfirmCode(String email);
}
