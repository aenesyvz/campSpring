package kodlama.io.rentACar.business.concretes;

import java.security.SecureRandom;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ActivationCodeService;
import kodlama.io.rentACar.core.entities.User;
import kodlama.io.rentACar.core.utilities.results.ErrorResult;
import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.core.utilities.results.SuccessResult;
import kodlama.io.rentACar.dataAccess.abstracts.ActivationCodeRepository;
import kodlama.io.rentACar.dataAccess.abstracts.UserRepository;
import kodlama.io.rentACar.entities.concretes.ActivationCode;

@Service
public class ActivationCodeManager implements ActivationCodeService{

	private ActivationCodeRepository activationCodeRepository;
	private UserRepository userRepository;
	
	@Autowired
	public ActivationCodeManager(ActivationCodeRepository activationCodeRepository, UserRepository userRepository) {
		super();
		this.activationCodeRepository = activationCodeRepository;
		this.userRepository = userRepository;
	}

	@Override
	public ActivationCode getByCode(String code) {
		 return this.activationCodeRepository.findByCode(code);
	}

	String generatedCode="";
	@Override
	public String createActivationCode(User user) {
		//for(int i=0;i==0;i=0){
            generatedCode = rastgeleDegerSaglayici(16);

           // if(getByCode(generatedCode) == null){
              //  break;
           // }
		//}
		
		 ActivationCode activationCode=new ActivationCode();
	        activationCode.setUserId(user.getId());
	        activationCode.setCode(generatedCode);
	        Date date = new Date(); 
	        date.setMinutes(date.getMinutes() + 3);
	        activationCode.setExpired_date(date);
	        activationCodeRepository.save(activationCode);

	        return generatedCode;
	}

	@Override
	public boolean activationUser(String code) {
		 if(activationCodeRepository.findByCode(code) == null){
	            return false;
	        }

	        User user = userRepository.getById(activationCodeRepository.findByCode(code).getUserId());
	        if(user.isMailVerify()){
	            return false;
	        }
	        user.setMailVerify(true);
	        userRepository.save(user);

	        ActivationCode activationCode=activationCodeRepository.findByCode(code);
	        activationCode.setVerifayed(true);
	        activationCode.setVerifyDate(new Date());
	        activationCodeRepository.save(activationCode);

	        return true;
	}

	@Override
	public Result confirmUserEmailForResetPassword(String email,String code) {
		 ActivationCode activationCode=activationCodeRepository.findByCode(code);
		 	if(activationCode == null){
	            return new ErrorResult("Hatalı doğrulama kodu  jdjsf");
	        }
		 	User user = this.userRepository.findByEmail(email).get();
	        if(user.getId() != activationCode.getUserId()){
	        	 return new ErrorResult(user.getId() + " => " + activationCode.getUserId());	        
	        }
	        
	        if(activationCode.getExpired_date().compareTo(new Date()) < 0) {
	        	 return new ErrorResult("Süre doldu tekrar deneyiniz!");
	        }
	 
	        activationCode.setVerifayed(true);
	        activationCode.setVerifyDate(new Date());
	        activationCodeRepository.save(activationCode);

	        return new SuccessResult();
	}

	@Override
	public String createConfirmCode(String email) {
		  generatedCode = rastgeleDegerSaglayici(4);

		  User user = this.userRepository.findByEmail(email).get();
		  
		  
		 ActivationCode activationCode=new ActivationCode();
	        activationCode.setUserId(user.getId());
	        activationCode.setCode(generatedCode);
	        Date date = new Date(); 
	        date.setMinutes(date.getMinutes() + 3);
	        activationCode.setExpired_date(date);
	        activationCodeRepository.save(activationCode);

	        return generatedCode;
	}
	
	
	
	
	
	
	private final String nelerOlsun = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private SecureRandom karistirici = new SecureRandom();
    private String rastgeleDegerSaglayici(int uzunluk){
        StringBuilder rastgeleDegerYapici = new StringBuilder(uzunluk);
        for(int i=0;i<uzunluk;i++){
            rastgeleDegerYapici.append(nelerOlsun.charAt(karistirici.nextInt(nelerOlsun.length())));
        }
        return rastgeleDegerYapici.toString();
    }

	
}
