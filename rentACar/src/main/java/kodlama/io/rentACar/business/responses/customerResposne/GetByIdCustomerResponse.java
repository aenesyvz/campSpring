package kodlama.io.rentACar.business.responses.customerResposne;

public class GetByIdCustomerResponse {
	public int id;
	public int userId;
	public GetByIdCustomerResponse() {
		super();
		
	}
	public GetByIdCustomerResponse(int id, int userId) {
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
