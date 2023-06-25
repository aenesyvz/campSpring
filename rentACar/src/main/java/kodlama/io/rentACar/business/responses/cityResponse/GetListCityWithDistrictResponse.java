package kodlama.io.rentACar.business.responses.cityResponse;

import java.util.List;

import kodlama.io.rentACar.entities.concretes.District;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListCityWithDistrictResponse {
	private int id;
	private int plateCode;
	private String name;
	private List<District> districts;
}
