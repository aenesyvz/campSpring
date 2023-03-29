package kodlama.io.rentACar.entities.concretes;

import java.util.Date;

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
@Table(name="invoices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public int id;
	
	@Column(name="customer_id")
	public int customerId;
	
	@Column(name="car_id")
	public int carId;
	
	@Column(name="no")
	public String no;
	
	@Column(name="create_data")
	public Date createData;
	
	@Column(name="rental_start_date")
	public Date rentalStartDate;
	
	@Column(name="rental_end_date")
	public Date rentalEndDate;
	
	@Column(name="total_rental_date")
	public int totalRentalDate;
	
	@Column(name="rental_price")
	public int rentalPrice;

	
}
