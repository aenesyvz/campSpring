package kodlama.io.rentACar.business.responses.corporateCustomerResponse;

public class GetByIdCorporateCustomerResponse {
	public int id;
	public int customerId;
	public String companyName;
	public String taxNo;
	public GetByIdCorporateCustomerResponse() {
		super();
	}
	public GetByIdCorporateCustomerResponse(int id, int customerId, String companyName, String taxNo) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.companyName = companyName;
		this.taxNo = taxNo;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getTaxNo() {
		return taxNo;
	}
	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}
}
