package kodlama.io.rentACar.business.responses.carResponse;

import kodlama.io.rentACar.entities.concretes.CarImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListCarResponse {
	public int id;
	public int brandId;
	public String brandName;
	public String name;
	public int modelId;
	public String modelName;
	public int modelYear;
	public int carStateId;
	public int minFindeksCreditRate;
	public CarImage carImage;
}
