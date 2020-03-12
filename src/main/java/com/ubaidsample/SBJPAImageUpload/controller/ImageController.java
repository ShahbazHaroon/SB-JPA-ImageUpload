package com.ubaidsample.SBJPAImageUpload.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ubaidsample.SBJPAImageUpload.model.Images;
import com.ubaidsample.SBJPAImageUpload.repository.ImageRepository;

@RestController
@RequestMapping("image")
public class ImageController {

	@Autowired
	private ImageRepository imageRepository;

	// Return the image from the database using ResponseEntity
	@GetMapping("database/{id}")
	public ResponseEntity<byte[]> fromDatabaseAsResEntity(@PathVariable("id") Integer id) throws SQLException {

		Optional<Images> primeMinisterOfIndia = imageRepository.findById(id);
		byte[] imageBytes = null;
		if (primeMinisterOfIndia.isPresent()) {

			imageBytes = primeMinisterOfIndia.get().getPhoto().getBytes(1,
					(int) primeMinisterOfIndia.get().getPhoto().length());
		}

		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	}

	// Return the image from the database using HttpServletResponse
	@GetMapping(value = "database1/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void fromDatabaseAsHttpServResp(@PathVariable("id") Integer id, HttpServletResponse response)
			throws SQLException, IOException {

		Optional<Images> primeMinisterOfIndia = imageRepository.findById(id);

		if (primeMinisterOfIndia.isPresent()) {

			Blob image = primeMinisterOfIndia.get().getPhoto();

			StreamUtils.copy(image.getBinaryStream(), response.getOutputStream());
		}
	}

	// Return the image from the classpath location using ResponseEntity
	@GetMapping(value = "fromClasspath")
	public ResponseEntity<byte[]> fromClasspathAsResEntity() throws IOException {

		ClassPathResource imageFile = new ClassPathResource("images/GMC.jpg");

		byte[] imageBytes = StreamUtils.copyToByteArray(imageFile.getInputStream());

		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	}

	// Return the image from the classpath location using HttpServletResponse
	@GetMapping(value = "fromClasspath1", produces = MediaType.IMAGE_JPEG_VALUE)
	public void fromClasspathAsHttpServResp(HttpServletResponse response) throws IOException {

		ClassPathResource imageFile = new ClassPathResource("images/Ford.jpg");

		StreamUtils.copy(imageFile.getInputStream(), response.getOutputStream());
	}
}
