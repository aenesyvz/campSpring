package kodlama.io.rentACar.business.responses.carDamageResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdCarDamageResponse {
	public int id;
	public int carId;
	public String damageDescription;
	public boolean isFixed;
	
}
