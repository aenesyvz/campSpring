package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.City;

public interface CityRepository extends JpaRepository<City, Integer>{
	boolean existsByName(String name);
}
