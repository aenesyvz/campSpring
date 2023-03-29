package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.CarImageService;
import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.carRequest.CreateCarRequest;
import kodlama.io.rentACar.business.requests.carRequest.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.carImageResponse.GetListCarImageResponse;
import kodlama.io.rentACar.business.responses.carResponse.GetByIdCarResponse;
import kodlama.io.rentACar.business.responses.carResponse.GetListCarResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import kodlama.io.rentACar.entities.concretes.Car;
import kodlama.io.rentACar.entities.concretes.CarImage;

@Service
public class CarManager implements CarService{
	private ModelMapperService modelMapperService;
	private CarRepository carRepository;
	private CarImageService carImageService;
	
	@Autowired
	public CarManager(ModelMapperService modelMapperService, CarRepository carRepository,CarImageService carImageService) {
		super();
		this.modelMapperService = modelMapperService;
		this.carRepository = carRepository;
		this.carImageService = carImageService;
	}

	@Override
	public List<GetListCarResponse> getAll() {
		List<Car> cars = this.carRepository.findAll();
		List<GetListCarResponse> listResponse = cars.stream()
				.map(car -> this.modelMapperService.forResponse().
						map(car, GetListCarResponse.class)).collect(Collectors.toList());
		
		for (GetListCarResponse getListCarResponse : listResponse) {
			CarImage carImage = this.carImageService.getListByCarId(getListCarResponse.getId()).get(0);
			getListCarResponse.setCarImage(carImage);
		}
		
		return listResponse;
		
	}

	@Override
	public GetByIdCarResponse getById(int id)  {
		Optional<Car> car = this.carRepository.findById(id);
		GetByIdCarResponse response = this.modelMapperService.forResponse().map(car.get(), GetByIdCarResponse.class);
		
		List<CarImage> carImages = this.carImageService.getListByCarId(id);
		
		List<GetListCarImageResponse> carImageResponse = carImages.stream()
				.map(carImage -> this.modelMapperService.forResponse()
						.map(carImage, GetListCarImageResponse.class)).collect(Collectors.toList());
		response.setCarImages(carImageResponse);
		
		return response;
	}

	@Override
	public void add(CreateCarRequest createCarRequest) {
		Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		car.setId(0);
		this.carRepository.save(car);
	}

	@Override
	public void update(UpdateCarRequest updateCarRequest) {
		Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
		this.carRepository.save(car);
	}

	@Override
	public void delete(int id) {
		this.carRepository.deleteById(id);
	}


}
