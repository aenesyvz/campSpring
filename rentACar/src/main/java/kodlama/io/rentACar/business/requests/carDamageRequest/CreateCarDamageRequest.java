package kodlama.io.rentACar.business.requests.carDamageRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarDamageRequest {
	
	public int carId;
	public String DamageDescription;
	public boolean isFixed;
	

	
}
