package kodlama.io.rentACar.webApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.ActivationCodeService;
import kodlama.io.rentACar.core.utilities.results.Result;

@RestController
@RequestMapping("/api/activationcode")
@CrossOrigin
public class ActivationCodeController {
	private ActivationCodeService activationCodeService;

    @Autowired
    public ActivationCodeController(ActivationCodeService activationCodeService) {
        this.activationCodeService = activationCodeService;
    }
    
    @GetMapping("/active/{code}")
    public boolean activateUser(@PathVariable String code){
        return this.activationCodeService.activationUser(code);
       
    }
    
    @GetMapping("/confirm")
    public Result confirmUser(String email,String code){
        return this.activationCodeService.confirmUserEmailForResetPassword(email,code);
       
    }
}
