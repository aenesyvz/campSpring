package kodlama.io.rentACar.business.responses.carResponse;

import java.util.List;

import kodlama.io.rentACar.business.responses.carImageResponse.GetListCarImageResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdCarResponse {
	public int id;
	public int brandId;
	public String brandName;
	public String name;
	public int colorId;
	public String colorName;
	public int modelId;
	public String modelName;
	public int kilometer;
	public int modelYear;
	public String plate;
	public String rentalBranchCityName;
	public String rentalBranchDistrictName;
	public String rentalBranchAddress;
	public int transmissionId;
	public String transmissionName;
	public int fuelId;
	public String fuelName;
	public int carStateId;
	public int minFindeksCreditRate;
	public int motorPower;
	public int torque;
	public List<GetListCarImageResponse> carImages;
}
