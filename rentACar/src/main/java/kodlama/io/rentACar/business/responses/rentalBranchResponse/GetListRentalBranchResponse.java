package kodlama.io.rentACar.business.responses.rentalBranchResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListRentalBranchResponse {
	public int id;
	public String cityName;
	public String districtName;
	public String name;
	public String address;
	public String phoneNumber;
	public String email;
}
