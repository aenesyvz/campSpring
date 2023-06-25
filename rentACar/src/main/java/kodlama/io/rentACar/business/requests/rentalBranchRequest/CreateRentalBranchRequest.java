package kodlama.io.rentACar.business.requests.rentalBranchRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRentalBranchRequest {
	public int cityId;
	public int districtId;
	public String name;
	public String address;
	public String phoneNumber;
	public String email;
}
