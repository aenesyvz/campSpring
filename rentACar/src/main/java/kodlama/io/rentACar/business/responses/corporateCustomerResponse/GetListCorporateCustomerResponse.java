package kodlama.io.rentACar.business.responses.corporateCustomerResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListCorporateCustomerResponse {
	public int id;
	public int userId;
	public String companyName;
	public String taxNo;
	private String phoneNumber;
	private boolean verificationStatus;
	private String email;
	private String password;
	public boolean status;
	public boolean isMailVerify;
	public int role;
}
