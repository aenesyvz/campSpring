package kodlama.io.rentACar.business.requests.rentalBranchRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRentalBranchRequest {
	public int id;
	public int cityId;
	public String name;
	public String address;
	
}