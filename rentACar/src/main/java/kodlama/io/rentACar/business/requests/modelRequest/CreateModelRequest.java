package kodlama.io.rentACar.business.requests.modelRequest;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateModelRequest {
	
	@NotNull
	@NotBlank
	private String name;
	
	@NotNull
	
	private int brandId;
	
}
