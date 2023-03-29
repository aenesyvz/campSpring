package kodlama.io.rentACar.business.responses.brandResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdBrandResponse {
		private int id;
		private String name;
}
