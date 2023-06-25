package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.entities.concretes.Staff;

@Service
public interface StaffRepository extends JpaRepository<Staff, Integer>{

}
