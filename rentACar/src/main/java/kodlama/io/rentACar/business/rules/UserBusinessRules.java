package kodlama.io.rentACar.business.rules;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.userRequest.ResetPasswordRequest;
import kodlama.io.rentACar.core.entities.User;
import kodlama.io.rentACar.core.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.UserRepository;

@Service
public class UserBusinessRules {
	private UserRepository userRepository;

	@Autowired
	public UserBusinessRules(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public void CheckIfEmailExists(String email) {
		if(this.userRepository.existsByEmail(email)) {
			throw new BusinessException("Email already registered");
		}
	}
	
	public void  CheckIfConfirmPassword(ResetPasswordRequest resetPasswordRequest) {
		if(resetPasswordRequest.getNewPassword() != resetPasswordRequest.getReNewPassword()){
			throw new BusinessException("Şifreler uyuşmuyor!");
		}
	}
	
	public void  CheckExistsUser(Optional<User> user) {
		if(!user.isPresent()) {
			throw new BusinessException("Kullanıcı bulunamadı!");
			}
	}

	public void  CheckIfUserEmailVerify(Optional<User> user) {
		 if(!user.get().isMailVerify()){
			 throw new BusinessException("Lütfen email adresinizi kontrol edip email adresinizi doğrulayın!");
	     }
	}
	
}
