package kodlama.io.rentACar.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.UserService;
import kodlama.io.rentACar.business.requests.userRequest.CreateUserRequest;
import kodlama.io.rentACar.business.requests.userRequest.LoginRequest;
import kodlama.io.rentACar.business.requests.userRequest.ResetPasswordRequest;
import kodlama.io.rentACar.business.requests.userRequest.UpdateUserRequest;
import kodlama.io.rentACar.business.responses.userResponse.GetByIdUserResponse;
import kodlama.io.rentACar.business.responses.userResponse.GetListUserResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UsersController {
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getAll")
	public List<GetListUserResponse> getAll(){
		return this.userService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public GetByIdUserResponse getById(@PathVariable int id) {
		return this.userService.getById(id);
	}
	
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() CreateUserRequest createUserRequest) {
		this.userService.add(createUserRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody() UpdateUserRequest updateUserRequest) {
		this.userService.update(updateUserRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.userService.delete(id);
	}
	
	
	@GetMapping("/sendConfirmCode/{email}")
	public void sendConfirmCode(@PathVariable String email) {
		this.userService.sendConfirmCode(email);
	}
	
	@PostMapping("/login")
	public GetByIdUserResponse login(@RequestBody() LoginRequest loginRequest) {
		return this.userService.login(loginRequest);
	}
	
	
	@PutMapping("/resetPassword")
	public void resetPassword(@RequestBody() ResetPasswordRequest resetPasswordRequest) {
		this.userService.resetPassword(resetPasswordRequest);
	}
	
	
	
	
	
}
