package kodlama.io.rentACar.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlama.io.rentACar.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@Entity
@Table(name="corporate_customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CorporateCustomer extends User{
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="tax_no")
	private String taxNo;

	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="verification_status")
	private boolean verificationStatus;
	
	
}
