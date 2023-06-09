package kodlama.io.rentACar.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="rental_branchs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalBranch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public int id;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	public City city;
	
	@ManyToOne
	@JoinColumn(name="district_id")
	public District district;
	
	@Column(name="name")
	public String name;
	
	@Column(name="address")
	public String address;
	
	@Column(name="phone_number")
	public String phoneNumber;
	
	@Column(name="email")
	public String email;
}
