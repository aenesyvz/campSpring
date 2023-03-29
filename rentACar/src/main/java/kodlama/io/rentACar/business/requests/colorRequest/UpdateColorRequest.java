package kodlama.io.rentACar.business.requests.colorRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateColorRequest {
	private int id;
	private String name;
	
}
