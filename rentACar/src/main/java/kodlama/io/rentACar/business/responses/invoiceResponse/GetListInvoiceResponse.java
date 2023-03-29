package kodlama.io.rentACar.business.responses.invoiceResponse;

import java.util.Date;

public class GetListInvoiceResponse {
	public int id;
	public int customerId;
	public int carId;
	public String no;
	public Date createData;
	public Date rentalStartDate;
	public Date rentalEndDate;
	public int totalRentalDate;
	public int rentalPrice;
	public GetListInvoiceResponse() {
		super();
	}
	public GetListInvoiceResponse(int id, int customerId, int carId, String no, Date createData, Date rentalStartDate,
			Date rentalEndDate, int totalRentalDate, int rentalPrice) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.carId = carId;
		this.no = no;
		this.createData = createData;
		this.rentalStartDate = rentalStartDate;
		this.rentalEndDate = rentalEndDate;
		this.totalRentalDate = totalRentalDate;
		this.rentalPrice = rentalPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public Date getCreateData() {
		return createData;
	}
	public void setCreateData(Date createData) {
		this.createData = createData;
	}
	public Date getRentalStartDate() {
		return rentalStartDate;
	}
	public void setRentalStartDate(Date rentalStartDate) {
		this.rentalStartDate = rentalStartDate;
	}
	public Date getRentalEndDate() {
		return rentalEndDate;
	}
	public void setRentalEndDate(Date rentalEndDate) {
		this.rentalEndDate = rentalEndDate;
	}
	public int getTotalRentalDate() {
		return totalRentalDate;
	}
	public void setTotalRentalDate(int totalRentalDate) {
		this.totalRentalDate = totalRentalDate;
	}
	public int getRentalPrice() {
		return rentalPrice;
	}
	public void setRentalPrice(int rentalPrice) {
		this.rentalPrice = rentalPrice;
	}
}
