package kodlama.io.rentACar.business.requests.transmission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTransmissionRequest {
	private int id;
	private String name;
	
	
}
