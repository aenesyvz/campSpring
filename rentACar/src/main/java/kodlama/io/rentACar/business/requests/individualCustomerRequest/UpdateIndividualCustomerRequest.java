package kodlama.io.rentACar.business.requests.individualCustomerRequest;

public class UpdateIndividualCustomerRequest {
	public int id;
	public int customerId;
	public String firstName;
	public String lastName;
	public String nationaltyIdentity;
	public UpdateIndividualCustomerRequest() {
		super();
	}
	public UpdateIndividualCustomerRequest(int id, int customerId, String firstName, String lastName,
			String nationaltyIdentity) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationaltyIdentity = nationaltyIdentity;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNationaltyIdentity() {
		return nationaltyIdentity;
	}
	public void setNationaltyIdentity(String nationaltyIdentity) {
		this.nationaltyIdentity = nationaltyIdentity;
	}
}
