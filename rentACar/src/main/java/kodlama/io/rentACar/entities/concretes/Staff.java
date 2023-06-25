package kodlama.io.rentACar.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlama.io.rentACar.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@Entity
@Table(name="staffs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff extends User{
	@Column(name="first_name")
	public String firstName;
	
	@Column(name="last_name")
	public String lastName;
	
	@Column(name="nationality_identity")
	public String nationalityIdentity;
	
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="address")
	private String address;
}
