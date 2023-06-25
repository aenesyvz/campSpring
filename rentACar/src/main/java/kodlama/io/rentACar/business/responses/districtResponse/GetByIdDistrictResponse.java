package kodlama.io.rentACar.business.responses.districtResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdDistrictResponse {
	private int id;
	private String cityName;
	private int name;
}
