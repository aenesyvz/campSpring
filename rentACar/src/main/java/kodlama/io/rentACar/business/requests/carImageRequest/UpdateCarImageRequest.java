package kodlama.io.rentACar.business.requests.carImageRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarImageRequest {
	private int id;
	private int carId;
	private String imageUrl;
}
