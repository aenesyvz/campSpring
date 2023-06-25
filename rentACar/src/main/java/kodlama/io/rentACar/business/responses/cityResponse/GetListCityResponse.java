package kodlama.io.rentACar.business.responses.cityResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListCityResponse {
	private  int id;
	private int plateCode;
	private String name;
	
}
