package kodlama.io.rentACar.business.responses.individualCustomerResponse;

import java.time.LocalDate;

import kodlama.io.rentACar.business.responses.userResponse.GetByIdUserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdIndividualCustomerResponse extends GetByIdUserResponse{
	public int id;
	public String email;
	public String password;
	public String firstName;
	public String lastName;
	public String nationalityIdentity;
	private LocalDate dateOfBirth;
	private String phoneNumber;
}
