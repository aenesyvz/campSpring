package kodlama.io.rentACar.business.requests.staffRequest;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateStaffRequest {
	public String email;
	public String password;
	public String firstName;
	public String lastName;
	public String nationalityIdentity;
	private LocalDate dateOfBirth;
	private String phoneNumber;
	private String address;
}
