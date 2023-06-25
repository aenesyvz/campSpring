package kodlama.io.rentACar.business.requests.districtRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDistrictRequest {
	private int cityId;
	private String name;
}
