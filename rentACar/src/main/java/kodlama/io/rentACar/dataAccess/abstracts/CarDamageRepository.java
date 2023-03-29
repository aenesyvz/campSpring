package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.CarDamage;

public interface CarDamageRepository extends JpaRepository<CarDamage, Integer>{

}
