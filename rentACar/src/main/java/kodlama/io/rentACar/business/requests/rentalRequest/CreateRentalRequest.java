package kodlama.io.rentACar.business.requests.rentalRequest;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRentalRequest {
	public int carId;
	public int customerId;
	public int rentStartRentalBranchId;
	public int rentEndRentalBranchId;
	public Date rentalStartDate;
	public Date rentalEndDate;
	public Date returnDate;
	public int rentStartKilometer;
	
	
}
