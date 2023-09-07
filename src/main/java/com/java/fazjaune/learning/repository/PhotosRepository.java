package com.java.fazjaune.learning.repository;

import com.java.fazjaune.learning.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotosRepository extends CrudRepository<Photo, Integer> {

}
