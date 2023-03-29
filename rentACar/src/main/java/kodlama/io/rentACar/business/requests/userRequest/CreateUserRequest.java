package kodlama.io.rentACar.business.requests.userRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
	public String email;
	public String password;
	public boolean status;
	
	
}
