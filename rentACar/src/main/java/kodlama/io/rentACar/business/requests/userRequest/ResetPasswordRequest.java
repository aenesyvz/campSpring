package kodlama.io.rentACar.business.requests.userRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResetPasswordRequest {
	private String email;
	private String newPassword;
	private String reNewPassword;
}
