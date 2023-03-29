package kodlama.io.rentACar.business.responses.individualCustomerResponse;

public class GetListIndividualCustomerResponse {
	public int id;
	public int userId;
	public GetListIndividualCustomerResponse() {
		super();
		
	}
	public GetListIndividualCustomerResponse(int id, int userId) {
		super();
		this.id = id;
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
