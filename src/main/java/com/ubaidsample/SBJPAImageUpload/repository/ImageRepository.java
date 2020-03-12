package com.ubaidsample.SBJPAImageUpload.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ubaidsample.SBJPAImageUpload.model.Images;

@Repository
public interface ImageRepository extends JpaRepository<Images, Integer> {
	
	public Optional<Images> findById(Integer id);

}
