package kodlama.io.rentACar.business.responses.individualCustomerResponse;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListIndividualCustomerResponse {
	public int id;
	public String email;
	public String password;
	public String firstName;
	public String lastName;
	public String nationalityIdentity;
	private LocalDate dateOfBirth;
	private String phoneNumber;
}
