package kodlama.io.rentACar.business.requests.modelRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateModelRequest {
	public int id;
	public int brandId;
	public String name;
	
	
}
