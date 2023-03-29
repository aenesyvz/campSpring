package kodlama.io.rentACar.business.responses.userResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListUserResponse {
	public int id;
	public String email;
	public String password;
	public boolean status;
	public boolean isMailVerify;
	public int role;
}
