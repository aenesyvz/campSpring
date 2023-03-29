package kodlama.io.rentACar.business.requests.corporateCustomerRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCorporateCustomerRequest {
	public String email;
	public String password;
	public String companyName;
	public String taxNo;
	public String phoneNumber;
	
}
