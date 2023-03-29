package kodlama.io.rentACar.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public int id;

	@Column(name="name")
	public String name;
	
	@ManyToOne
	@JoinColumn(name="color_id")
	public Color color;
	
	@ManyToOne
	@JoinColumn(name="model_id")
	public Model model;
	
	@ManyToOne
	@JoinColumn(name="brand_id")
	public Brand brand;
	
	@ManyToOne
	@JoinColumn(name="transmission_id")
	public Transmission transmission;
	
	@ManyToOne
	@JoinColumn(name="fuel_id")
	public Fuel fuel;
	
	@OneToMany(mappedBy = "car")
	public List<CarDamage> carDamages;
	
	@OneToMany(mappedBy = "car")
	private List<CarImage> carImages;
	
	@Column(name="kilometer")
	public int kilometer;
	
	@Column(name="modelYear")
	public int modelYear;
	
	@Column(name="plate")
	public String plate;
	
	@Column(name="carState")
	public int carState;
	
	@Column(name="minFindeksCreditRate")
	public int minFindeksCreditRate;
	
	@Column(name="motor_power")
	public int motorPower;
	
	@Column(name="torque")
	public int torque;

}
