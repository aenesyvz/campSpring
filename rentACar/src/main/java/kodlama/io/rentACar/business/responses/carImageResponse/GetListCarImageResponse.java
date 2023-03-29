package kodlama.io.rentACar.business.responses.carImageResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListCarImageResponse {
	private int id;
	private int carId;
	private String imageUrl;
}
