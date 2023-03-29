package kodlama.io.rentACar.core.utilities.helpers.image;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.rentACar.core.entities.Image;

public interface ImageService {
	Image save(MultipartFile file);

	void delete(String id);
}
