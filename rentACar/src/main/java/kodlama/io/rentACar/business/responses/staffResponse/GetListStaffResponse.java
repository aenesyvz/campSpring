package kodlama.io.rentACar.business.responses.staffResponse;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListStaffResponse {
	private int id;
	public String email;
	public String password;
	public String firstName;
	public String lastName;
	public String nationalityIdentity;
	private LocalDate dateOfBirth;
	private String phoneNumber;
	private String address;
}
