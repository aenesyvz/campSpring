package kodlama.io.rentACar.business.responses.modelResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdModelResponse {
	public int id;
	public int brandId;
	public String name;
	
	
}
