package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.ActivationCode;

public interface ActivationCodeRepository extends JpaRepository<ActivationCode, Integer>{
	ActivationCode findByCode(String code);
}
