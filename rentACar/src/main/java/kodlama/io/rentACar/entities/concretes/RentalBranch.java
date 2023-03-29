package kodlama.io.rentACar.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="city_id")
	public int cityId;
	
	@Column(name="name")
	public String name;
	
	@Column(name="address")
	public String address;


	
}
