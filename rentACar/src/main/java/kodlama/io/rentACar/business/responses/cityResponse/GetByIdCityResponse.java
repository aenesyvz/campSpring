package kodlama.io.rentACar.business.responses.cityResponse;

import java.util.List;

import kodlama.io.rentACar.business.responses.districtResponse.GetListDistrictResponse;
import kodlama.io.rentACar.entities.concretes.District;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdCityResponse {
	public int id;
	public int plateCode;
	public String name;
	public List<GetListDistrictResponse> districts;
}
