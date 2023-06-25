package kodlama.io.rentACar.business.requests.carRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarRequest {
	public int brandId;
	public String name;
	public int colorId;
	public int modelId;
	public int kilometer;
	public int modelYear;
	public String plate;
	public int rentalBranchId;
	public int transmissionId;
	public int fuelId;
	public int carStateId;
	public int minFindeksCreditRate;
	public int motorPower;
	public int torque;
}
