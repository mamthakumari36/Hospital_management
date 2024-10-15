package org.jsp.hms.service;

import java.util.List;
import java.util.Optional;

import org.jsp.hms.dao.DepartmentDao;
import org.jsp.hms.dao.HospitalDao;
import org.jsp.hms.entity.Department;
import org.jsp.hms.entity.Hospital;
import org.jsp.hms.responseStructure.ResponseStructure;
import org.jsp.hms.service.exceptionClass.InvalidIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DepartmentService {
	@Autowired
	private DepartmentDao dao;

	@Autowired
	HospitalDao hDao;

	public ResponseEntity<?> saveDepartment(int id, Department department) {
		Optional<Hospital> optional = hDao.findHosById(id);
		if (optional.isEmpty())
			throw InvalidIdException.builder().message("Invalid hospital id").build();

		Hospital h = optional.get();
		department.setHospital(h);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.builder().status(HttpStatus.CREATED.value()).message("Saved Successfully")
						.body(dao.saveDepartment(department)).build());
	}

	public ResponseEntity<?> getDeptByHospId(int id) {
		List<Department> dept = dao.getDeptByHospId(id);
		if (dept.isEmpty())
			return null;

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Found All details Successfully").body(dept).build());
	}

}
