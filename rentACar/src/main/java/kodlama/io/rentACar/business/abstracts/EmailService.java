package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.core.entities.User;

public interface EmailService {
	void sendVerifyEmail(User user,String code);
	void sendConfirmCode(User user,String code);
}
