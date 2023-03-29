package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.rentalBranchRequest.CreateRentalBranchRequest;
import kodlama.io.rentACar.business.requests.rentalBranchRequest.UpdateRentalBranchRequest;
import kodlama.io.rentACar.business.responses.rentalBranchResponse.GetByIdRentalBranchResponse;
import kodlama.io.rentACar.business.responses.rentalBranchResponse.GetListRentalBranchResponse;

@Service
public interface RentalBranchService {
	List<GetListRentalBranchResponse> getAll();
	GetByIdRentalBranchResponse getById(int id);
	void add(CreateRentalBranchRequest createRentalBranchRequest);
	void update(UpdateRentalBranchRequest updateRentalBranchRequest);
	void delete(int id);
}
