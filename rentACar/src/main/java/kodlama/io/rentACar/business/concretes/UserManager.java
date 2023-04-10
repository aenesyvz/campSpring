package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ActivationCodeService;
import kodlama.io.rentACar.business.abstracts.CorporateCustomerService;
import kodlama.io.rentACar.business.abstracts.EmailService;
import kodlama.io.rentACar.business.abstracts.IndividualCustomerService;
import kodlama.io.rentACar.business.abstracts.UserService;
import kodlama.io.rentACar.business.requests.userRequest.CreateUserRequest;
import kodlama.io.rentACar.business.requests.userRequest.LoginRequest;
import kodlama.io.rentACar.business.requests.userRequest.ResetPasswordRequest;
import kodlama.io.rentACar.business.requests.userRequest.UpdateUserRequest;
import kodlama.io.rentACar.business.responses.userResponse.GetByIdUserResponse;
import kodlama.io.rentACar.business.responses.userResponse.GetListUserResponse;
import kodlama.io.rentACar.business.rules.UserBusinessRules;
import kodlama.io.rentACar.core.entities.User;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.UserRepository;

@Service
public class UserManager implements UserService{
	private ModelMapperService modelMapperService;
	private UserRepository userRepository;
	private EmailService emailService;
	private ActivationCodeService activationCodeService;
	private CorporateCustomerService corporateCustomerService;
	private IndividualCustomerService individualCustomerService;
	private UserBusinessRules userBusinessRules;
	@Autowired
	public UserManager(ModelMapperService modelMapperService,
						UserRepository userRepository,
						EmailService emailService,
						ActivationCodeService activationCodeService,
						CorporateCustomerService corporateCustomerService,
						IndividualCustomerService individualCustomerService,
						UserBusinessRules userBusinessRules) {
		super();
		this.modelMapperService = modelMapperService;
		this.userRepository = userRepository;
		this.emailService = emailService;
		this.activationCodeService = activationCodeService;
		this.corporateCustomerService = corporateCustomerService;
		this.individualCustomerService = individualCustomerService;
		this.userBusinessRules = userBusinessRules;
	}
	
	@Override
	public List<GetListUserResponse> getAll() {
		List<User> users = this.userRepository.findAll();
		List<GetListUserResponse> listResponse = users.stream()
				.map(user -> this.modelMapperService.forResponse()
						.map(user, GetListUserResponse.class)).collect(Collectors.toList());
		return listResponse;
	}
	
	@Override
	public GetByIdUserResponse getById(int id) {
		Optional<User> user = this.userRepository.findById(id);
		GetByIdUserResponse response = this.modelMapperService.forResponse()
											.map(user.get(), GetByIdUserResponse.class);
		return response;
	}
	@Override
	public void add(CreateUserRequest createUserRequest) {
		User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);
		this.userRepository.save(user);
		
	}
	@Override
	public void update(UpdateUserRequest updateUserRequest) {
		User user = this.modelMapperService.forRequest().map(updateUserRequest, User.class);
		this.userRepository.save(user);
		
	}
	@Override
	public void delete(int id) {
		this.userRepository.deleteById(id);
		
	}
	
	@Override
	public GetByIdUserResponse login(LoginRequest loginRequest) {
		Optional<User> user = this.userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
		
		this.userBusinessRules.CheckExistsUser(user);
		this.userBusinessRules.CheckIfUserEmailVerify(user);

		GetByIdUserResponse userProfile = getUserProfile(user.get());
		return userProfile;
	}
	
	@Override
	public void sendConfirmCode(String email) {
		Optional<User> user = this.userRepository.findByEmail(email);
		
		this.userBusinessRules.CheckExistsUser(user);

		this.emailService.sendConfirmCode(user.get(),  this.activationCodeService.createConfirmCode(email));
	}

	@Override
	public void resetPassword(ResetPasswordRequest resetPasswordRequest) {
		Optional<User> user = this.userRepository.findByEmail(resetPasswordRequest.getEmail());

		this.userBusinessRules.CheckExistsUser(user);
		this.userBusinessRules.CheckIfUserEmailVerify(user);
		this.userBusinessRules.CheckIfConfirmPassword(resetPasswordRequest);
		
		user.get().setPassword(resetPasswordRequest.getNewPassword());
		this.userRepository.save(user.get());
	}
	
	
	
	private GetByIdUserResponse getUserProfile(User user) {
		if(user.getRole() == 3) {
			return this.corporateCustomerService.getByUserId(user.getId());
		}
		if(user.getRole() == 4) {
			return this.individualCustomerService.getByUserId(user.getId());
		}
		return null;
	}
	
	
}
