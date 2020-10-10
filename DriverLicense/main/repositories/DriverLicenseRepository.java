package com.codingdojo.driverlicense.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.driverlicense.models.DriverLicense;

@Repository
public interface DriverLicenseRepository extends CrudRepository<DriverLicense, Long> {
	List<DriverLicense> findAll();
}
