package kodlama.io.rentACar.business.requests.customerRequest;

public class CreateCustomerRequest {
	public int userId;

	public CreateCustomerRequest() {
		super();
	}

	public CreateCustomerRequest(int userId) {
		super();
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
