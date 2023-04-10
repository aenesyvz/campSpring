package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.Transmission;

public interface TransmissionRepository extends JpaRepository<Transmission, Integer>{
	boolean existsByName(String name);
}
