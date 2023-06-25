package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ActivationCodeService;
import kodlama.io.rentACar.business.abstracts.EmailService;
import kodlama.io.rentACar.business.abstracts.StaffService;
import kodlama.io.rentACar.business.requests.staffRequest.CreateStaffRequest;
import kodlama.io.rentACar.business.requests.staffRequest.UpdateStaffRequest;
import kodlama.io.rentACar.business.responses.staffResponse.GetByIdStaffResponse;
import kodlama.io.rentACar.business.responses.staffResponse.GetListStaffResponse;
import kodlama.io.rentACar.business.rules.StaffBusinessRules;
import kodlama.io.rentACar.business.rules.UserBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.StaffRepository;
import kodlama.io.rentACar.entities.concretes.Staff;

@Service
public class StaffManager implements StaffService{
	private ModelMapperService modelMapperService;
	private StaffRepository staffRepository;
	private UserBusinessRules userBusinessRules;
	private StaffBusinessRules staffBusinessRules;
	private EmailService emailService;
	private ActivationCodeService activationCodeService;
	@Autowired
	public StaffManager(ModelMapperService modelMapperService,
			StaffRepository staffRepository,
			UserBusinessRules userBusinessRules,
			StaffBusinessRules staffBusinessRules,
			EmailService emailService,
			ActivationCodeService activationCodeService
			) {
		super();
		this.modelMapperService = modelMapperService;
		this.staffRepository = staffRepository;
		this.userBusinessRules = userBusinessRules;
		this.staffBusinessRules = staffBusinessRules;
	}
	
	@Override
	public List<GetListStaffResponse> getAll() {
		List<Staff> staffs = this.staffRepository.findAll();
		List<GetListStaffResponse> listResponse = staffs.stream()
				.map(staff -> this.modelMapperService.forResponse()
						.map(staff, GetListStaffResponse.class)).collect(Collectors.toList());
		
		return listResponse;
				
	}

	@Override
	public GetByIdStaffResponse getById(int id) {
		Optional<Staff> staff = this.staffRepository.findById(id);
		GetByIdStaffResponse response = this.modelMapperService.forResponse().map(staff, GetByIdStaffResponse.class);
		
		return response;
	}

	@Override
	public void add(CreateStaffRequest createStaffRequest) {
		this.userBusinessRules.CheckIfEmailExists(createStaffRequest.getEmail());
		
		Staff staff = this.modelMapperService.forRequest().map(createStaffRequest, Staff.class);
		staff.setId(0);
		staff.setId(0);
		staff.setMailVerify(false);
		staff.setRole(2);
		staff.setStatus(true);
		
		this.staffBusinessRules.CheckIfRealPerson(staff);
		
		this.staffRepository.save(staff);
		this.emailService.sendVerifyEmail(staff, this.activationCodeService.createActivationCode(staff));
	}
	

	@Override
	public void update(UpdateStaffRequest updateStaffRequest) {
		Staff staff = this.modelMapperService.forRequest().map(updateStaffRequest, Staff.class);
		this.staffRepository.save(staff);
	}

	@Override
	public void delete(int id) {
		Optional<Staff> staff =   this.staffRepository.findById(id);
		if(staff.isPresent()) {
			staff.get().setStatus(false);
			this.staffRepository.save(staff.get());
		}
	}

	@Override
	public GetByIdStaffResponse getByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
