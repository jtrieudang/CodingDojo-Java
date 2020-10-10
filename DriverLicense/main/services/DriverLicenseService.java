package com.codingdojo.driverlicense.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.driverlicense.models.DriverLicense;
import com.codingdojo.driverlicense.repositories.DriverLicenseRepository;

@Service
public class DriverLicenseService {
	private final DriverLicenseRepository driverlicenseRepository;

	private static String newNumber = "000000";

	public DriverLicenseService(DriverLicenseRepository driverlicenseRepository) {
		this.driverlicenseRepository = driverlicenseRepository;
	}

	public DriverLicense createLicense(DriverLicense driverlicense) {

		newNumber = String.format("%06d", Integer.parseInt(newNumber) + 1);
		driverlicense.setNumber(newNumber);
		return driverlicenseRepository.save(driverlicense);
	}

	public DriverLicense findDriverLicense(Long id) {
		Optional<DriverLicense> findLic = driverlicenseRepository.findById(id);
		if (findLic.isPresent()) {
			return findLic.get();
		} else {
			return null;
		}
	}
}