package kodlama.io.rentACar.business.responses.userResponse;

public class GetByIdUserResponse {
	public int id;
	public String email;
	public String password;
	public boolean status;
	public GetByIdUserResponse() {
		super();
	}
	public GetByIdUserResponse(int id, String email, String password, boolean status) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
