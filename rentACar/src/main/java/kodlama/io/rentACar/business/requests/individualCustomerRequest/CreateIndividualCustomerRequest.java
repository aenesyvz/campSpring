package kodlama.io.rentACar.business.requests.individualCustomerRequest;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateIndividualCustomerRequest {
	public String firstName;
	public String lastName;
	public String nationalityIdentity;
	private Date dateOfBirth;
}
