package kodlama.io.rentACar.business.requests.cityRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCityRequest {
	private int id;
	private int plateCode;
	private String name;
}
