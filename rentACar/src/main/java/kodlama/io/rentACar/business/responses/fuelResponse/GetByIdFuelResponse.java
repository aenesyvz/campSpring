package kodlama.io.rentACar.business.responses.fuelResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdFuelResponse {
	public int id;
	public String name;
	
}
