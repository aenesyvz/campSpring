package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.userRequest.CreateUserRequest;
import kodlama.io.rentACar.business.requests.userRequest.UpdateUserRequest;
import kodlama.io.rentACar.business.responses.userResponse.GetByIdUserResponse;
import kodlama.io.rentACar.business.responses.userResponse.GetListUserResponse;

@Service
public interface UserService {
	List<GetListUserResponse> getAll();
	GetByIdUserResponse getById(int id);
	void add(CreateUserRequest createUserRequest);
	void update(UpdateUserRequest updateUserRequest);
	void delete(int id);
}
