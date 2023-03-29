package kodlama.io.rentACar.core.utilities.helpers.image.cloudinary;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlama.io.rentACar.core.entities.Image;
import kodlama.io.rentACar.core.utilities.helpers.image.ImageService;

@Service
public class CloudinaryImageManager implements ImageService {
	private final Cloudinary cloudinary;

	@Autowired 
	public CloudinaryImageManager(/*final Environment environment*/) {
		/*cloudinary = new Cloudinary(ObjectUtils.asMap(
				"dlzjernw6",
				environment.getProperty("cloudinary.cloud.name"),
				"913794581655338",
				environment.getProperty("cloudinary.api.key"),
				"vIJ7-jHhR_qtpkGBesdvw-X5ZwU",
				environment.getProperty("cloudinary.api.secret")));*/
		Map config = new HashMap();
		config.put("cloud_name", "dlzjernw6");
		config.put("api_key", "913794581655338");
		config.put("api_secret", "vIJ7-jHhR_qtpkGBesdvw-X5ZwU");
		this.cloudinary = new Cloudinary(config);
	}

	@Override
	public Image save(final MultipartFile file) {
		final Map result;

			try {
				result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
				Image image = Image.builder()
						.id(String.valueOf(result.get("public_id")))
						.url(String.valueOf(result.get("url")))
						.bytes(Integer.parseInt(String.valueOf(result.get("bytes"))))
						.format(String.valueOf(result.get("format")))
						.height(Integer.parseInt(String.valueOf(result.get("height"))))
						.width(Integer.parseInt(String.valueOf(result.get("width"))))
						.build();

				return image;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new Image();
			}

		
	}

	@Override
	public void delete(final String id) {
		try {
			cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
		} catch (final IOException e) {
			e.printStackTrace();
		}

	}
}