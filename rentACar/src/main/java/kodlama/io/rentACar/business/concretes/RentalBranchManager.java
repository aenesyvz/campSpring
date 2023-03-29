package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.RentalBranchService;
import kodlama.io.rentACar.business.requests.rentalBranchRequest.CreateRentalBranchRequest;
import kodlama.io.rentACar.business.requests.rentalBranchRequest.UpdateRentalBranchRequest;
import kodlama.io.rentACar.business.responses.rentalBranchResponse.GetByIdRentalBranchResponse;
import kodlama.io.rentACar.business.responses.rentalBranchResponse.GetListRentalBranchResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.RentalBranchRepository;
import kodlama.io.rentACar.entities.concretes.RentalBranch;

@Service
public class RentalBranchManager implements RentalBranchService{
	private ModelMapperService modelMapperService;
	private RentalBranchRepository rentalBranchRepository;
	
	@Autowired
	public RentalBranchManager(ModelMapperService modelMapperService, RentalBranchRepository rentalBranchRepository) {
		super();
		this.modelMapperService = modelMapperService;
		this.rentalBranchRepository = rentalBranchRepository;
	}

	@Override
	public List<GetListRentalBranchResponse> getAll() {
		List<RentalBranch> rentalBranchs = this.rentalBranchRepository.findAll();
		List<GetListRentalBranchResponse> listResponse = rentalBranchs.stream()
				.map(rentalBranch -> this.modelMapperService.forResponse()
						.map(rentalBranch, GetListRentalBranchResponse.class)).collect(Collectors.toList());
		
		return listResponse;
	}

	@Override
	public GetByIdRentalBranchResponse getById(int id) {
		Optional<RentalBranch> rentalBranch = this.rentalBranchRepository.findById(id);
		GetByIdRentalBranchResponse response = this.modelMapperService.forResponse()
				.map(rentalBranch.get(), GetByIdRentalBranchResponse.class);
		
		return response;
	}

	@Override
	public void add(CreateRentalBranchRequest createRentalBranchRequest) {
		RentalBranch rentalBranch = this.modelMapperService.forRequest().map(createRentalBranchRequest, RentalBranch.class);
		this.rentalBranchRepository.save(rentalBranch);
		
	}

	@Override
	public void update(UpdateRentalBranchRequest updateRentalBranchRequest) {
		RentalBranch rentalBranch = this.modelMapperService.forRequest().map(updateRentalBranchRequest, RentalBranch.class);
		this.rentalBranchRepository.save(rentalBranch);
	}

	@Override
	public void delete(int id) {
		this.rentalBranchRepository.deleteById(id);
		
	}
	
	
}
