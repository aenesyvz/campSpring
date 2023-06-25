package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.staffRequest.CreateStaffRequest;
import kodlama.io.rentACar.business.requests.staffRequest.UpdateStaffRequest;
import kodlama.io.rentACar.business.responses.staffResponse.GetByIdStaffResponse;
import kodlama.io.rentACar.business.responses.staffResponse.GetListStaffResponse;

@Service
public interface StaffService {
	List<GetListStaffResponse> getAll();
	GetByIdStaffResponse getById(int id);
	void add(CreateStaffRequest createStaffRequest);
	void update(UpdateStaffRequest updateStaffRequest);
	void delete(int id);
	GetByIdStaffResponse getByUserId(int id);
}
