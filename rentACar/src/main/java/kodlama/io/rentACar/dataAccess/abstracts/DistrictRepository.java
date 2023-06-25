package kodlama.io.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.District;

public interface DistrictRepository extends JpaRepository<District, Integer>{
	List<District> findAllByCityId(int cityId);
	boolean existsByName(String name);
}
