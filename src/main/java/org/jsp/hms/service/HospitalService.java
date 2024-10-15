package org.jsp.hms.service;

import java.util.Optional;

import org.jsp.hms.dao.HospitalDao;
import org.jsp.hms.entity.Hospital;
import org.jsp.hms.responseStructure.ResponseStructure;
import org.jsp.hms.service.exceptionClass.InvalidIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class HospitalService {
	@Autowired
	HospitalDao dao;

	public ResponseEntity<?> saveHospital(Hospital hospital) {

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.builder().status(HttpStatus.CREATED.value()).message("Created Successfully")
						.body(dao.saveHospital(hospital)).build());
	}

	public ResponseEntity<?> getAllHospital() {
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Fetch All Details Successfully").body(dao.getAllHospital()).build());
	}

	public ResponseEntity<?> updateHospital(int id, Hospital hospital) {
		Optional<Hospital> optional = dao.findHosById(id);
		if (optional.isEmpty()) {
			throw InvalidIdException.builder().message("Id not found").build();
		}
		Hospital h = dao.updateHospital(hospital);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Updated Successfully").body(h).build());
	}

	public ResponseEntity<?> deleteHospitalById(int id) 
	{
		Optional<Hospital> optional = dao.findHosById(id);
		if (optional.isEmpty())
			throw InvalidIdException.builder().message("Id not found").build();
		dao.deleteHospitalById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Deleted successfully").body("Hospital Deleted Successfully"));
	}

}
