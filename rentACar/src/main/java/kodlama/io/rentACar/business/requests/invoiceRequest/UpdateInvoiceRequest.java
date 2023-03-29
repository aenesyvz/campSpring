package kodlama.io.rentACar.business.requests.invoiceRequest;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInvoiceRequest {
	public int id;
	public int customerId;
	public int carId;
	public String no;
	public Date createDate;
	public Date rentalStartDate;
	public Date rentalEndDate;
	public int totalRentalDate;
	public int rentalPrice;
	
}	
