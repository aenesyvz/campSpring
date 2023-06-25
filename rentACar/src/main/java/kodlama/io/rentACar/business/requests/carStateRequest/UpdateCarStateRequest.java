package kodlama.io.rentACar.business.requests.carStateRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarStateRequest {
	public int id;
	public String name;
}
