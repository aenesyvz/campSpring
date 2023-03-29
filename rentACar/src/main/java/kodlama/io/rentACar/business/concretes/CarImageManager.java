package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.rentACar.business.abstracts.CarImageService;
import kodlama.io.rentACar.business.requests.carImageRequest.UpdateCarImageRequest;
import kodlama.io.rentACar.business.responses.carImageResponse.GetByIdCarImageResponse;
import kodlama.io.rentACar.business.responses.carImageResponse.GetListCarImageResponse;
import kodlama.io.rentACar.core.entities.Image;
import kodlama.io.rentACar.core.utilities.helpers.image.ImageService;
import kodlama.io.rentACar.core.utilities.helpers.image.cloudinary.CloudinaryImageHelper;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CarImageRepository;
import kodlama.io.rentACar.entities.concretes.CarImage;

@Service

public class CarImageManager implements CarImageService{
	private ModelMapperService modelMapperService;
	private CarImageRepository carImageRepository;
	private  ImageService imageService;
	
	@Autowired
	public CarImageManager(ModelMapperService modelMapperService, CarImageRepository carImageRepository,ImageService imageService) {
		super();
		this.modelMapperService = modelMapperService;
		this.carImageRepository = carImageRepository;
		this.imageService = imageService;
	}

	@Override
	public List<GetListCarImageResponse> getList() {
		List<CarImage> carImages = this.carImageRepository.findAll();
		List<GetListCarImageResponse> listResponse = carImages.stream()
				.map(carImage -> this.modelMapperService.forResponse()
						.map(carImage, GetListCarImageResponse.class)).collect(Collectors.toList());
		
		return listResponse;
	}

	@Override
	public GetByIdCarImageResponse getById(int id) {
		Optional<CarImage> carImage = this.carImageRepository.findById(id);
		GetByIdCarImageResponse response = this.modelMapperService.forResponse()
				.map(carImage.get(), GetByIdCarImageResponse.class);
		
		return response;
	}

	@Override
	public void add(CarImage createCarImageRequest,MultipartFile file) {
		CarImage carImage = this.modelMapperService.forRequest().map(createCarImageRequest, CarImage.class);
		Image result = imageService.save(file);
		carImage.setId(0);
		carImage.setImageUrl(result.getUrl());
		this.carImageRepository.save(carImage);
	}

	@Override
	public void update(UpdateCarImageRequest updateCarImageRequest) {
		CarImage carImage = this.modelMapperService.forRequest().map(updateCarImageRequest, CarImage.class);
		this.carImageRepository.save(carImage);
	}

	@Override
	public void delete(int id) {
		Optional<CarImage> carImage = this.carImageRepository.findById(id);
		final String imagePublicId = CloudinaryImageHelper.getImagePublicIdFromUrl(carImage.get().getImageUrl());
		imageService.delete(imagePublicId);
		this.carImageRepository.deleteById(id);
	}

	@Override
	public List<CarImage> getListByCarId(int carId) {
		List<CarImage> carImages = this.carImageRepository.findAllByCarId(carId);
//		List<GetListCarImageResponse> listResponse = carImages.stream()
//				.map(carImage -> this.modelMapperService.forResponse()
//						.map(carImage, GetListCarImageResponse.class)).collect(Collectors.toList());
		
		return carImages;
	}

}
