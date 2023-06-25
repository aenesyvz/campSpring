package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.CarState;

public interface CarStateRepository extends JpaRepository<CarState, Integer>{
	boolean existsByName(String name);
}
