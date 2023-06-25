package kodlama.io.rentACar.business.requests.cityRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCityRequest {
	private int plateCode;
	private String name;
}
