package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.RentalBranch;

public interface RentalBranchRepository extends JpaRepository<RentalBranch, Integer>{

}
