package kodlama.io.rentACar.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="rentals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rental {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public int id;
	
	@Column(name="car_id")
	public int carId;
	
	@Column(name="customer_id")
	public int customerId;
	
	@Column(name="rent_start_rental_branch_id")
	public int rentStartRentalBranchId;
	
	@Nullable
	@Column(name="rent_end_rental_branch_id")
	public int rentEndRentalBranchId;
	
	@Column(name="rental_start_date")
	public Date rentalStartDate;
	
	@Column(name="rental_end_date")
	public Date rentalEndDate;
	
	@Nullable
	@Column(name="return_date")
	public Date returnDate;
	
	@Column(name="rent_start_kilometer")
	public int rentStartKilometer;

	@Nullable
	@Column(name="rent_end_kilometer")
	public int rentEndKilometer;
	
}
