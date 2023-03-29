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
@Table(name="cardamages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDamage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public int id;
	
	@Column(name="damage_description")
	public String DamageDescription;
	
	@Column(name="is_fixed")
	public boolean isFixed;
	
	@ManyToOne
	@JoinColumn(name = "car_id")
	private Car car;
}
