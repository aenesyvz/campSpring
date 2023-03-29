package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.core.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmail(String email);
}
