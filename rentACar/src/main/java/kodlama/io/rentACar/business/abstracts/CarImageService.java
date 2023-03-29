package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.rentACar.business.requests.carImageRequest.UpdateCarImageRequest;
import kodlama.io.rentACar.business.responses.carImageResponse.GetByIdCarImageResponse;
import kodlama.io.rentACar.business.responses.carImageResponse.GetListCarImageResponse;
import kodlama.io.rentACar.entities.concretes.CarImage;

@Service
public interface CarImageService {
	List<GetListCarImageResponse> getList();
	List<CarImage> getListByCarId(int carId);
	GetByIdCarImageResponse getById(int id);
	void add(CarImage createCarImageRequest,MultipartFile file);
	void update(UpdateCarImageRequest updateCarImageRequest);
	void delete(int id);
}
