package kodlama.io.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.CarImage;

public interface CarImageRepository extends JpaRepository<CarImage, Integer>{
	List<CarImage> findAllByCarId(int carId);
}
