package kodlama.io.rentACar.business.responses.carDamageResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListCarDamageResponse {
	public int id;
	public int carId;
	public String DamageDescription;
	public boolean isFixed;
	
}
