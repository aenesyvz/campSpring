package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.UserService;
import kodlama.io.rentACar.business.requests.userRequest.CreateUserRequest;
import kodlama.io.rentACar.business.requests.userRequest.UpdateUserRequest;
import kodlama.io.rentACar.business.responses.userResponse.GetByIdUserResponse;
import kodlama.io.rentACar.business.responses.userResponse.GetListUserResponse;
import kodlama.io.rentACar.core.entities.User;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.UserRepository;

@Service
public class UserManager implements UserService{
	private ModelMapperService modelMapperService;
	private UserRepository userRepository;
	
	@Autowired
	public UserManager(ModelMapperService modelMapperService, UserRepository userRepository) {
		super();
		this.modelMapperService = modelMapperService;
		this.userRepository = userRepository;
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
	
}
