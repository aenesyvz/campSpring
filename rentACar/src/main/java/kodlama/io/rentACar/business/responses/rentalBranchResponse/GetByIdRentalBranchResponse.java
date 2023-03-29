package kodlama.io.rentACar.business.responses.rentalBranchResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdRentalBranchResponse {
	public int id;
	public int cityId;
	public String name;
	public String address;
	
}
