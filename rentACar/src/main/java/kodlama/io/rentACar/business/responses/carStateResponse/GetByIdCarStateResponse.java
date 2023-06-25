package kodlama.io.rentACar.business.responses.carStateResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdCarStateResponse {
	public int id;
	public String name;
}
