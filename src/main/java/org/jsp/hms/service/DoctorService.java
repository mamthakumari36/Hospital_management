package org.jsp.hms.service;

import java.util.List;
import java.util.Optional;

import org.jsp.hms.dao.DepartmentDao;
import org.jsp.hms.dao.DoctorDao;
import org.jsp.hms.dao.HospitalDao;
import org.jsp.hms.entity.Department;
import org.jsp.hms.entity.Doctor;
import org.jsp.hms.entity.Hospital;
import org.jsp.hms.responseStructure.ResponseStructure;
import org.jsp.hms.service.exceptionClass.InvalidIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DoctorService {
	@Autowired
	private DoctorDao dao;

	@Autowired
	private HospitalDao hDao;
	
	@Autowired
	private DepartmentDao dDao;

	public ResponseEntity<?> saveDoctor(int id, Doctor doctor) 
	{
		Optional<Hospital> hospital = hDao.findHosById(id);
//		Optional<Department> d = hDao.findDeptById(id);
		if (hospital.isEmpty())
			throw InvalidIdException.builder().message("Invalid Id").build();
		
		Hospital h = hospital.get();
		doctor.setHospital(h);
//		doctor.setDepartment(h);
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.builder()
				.status(HttpStatus.CREATED.value()).message("Saved successfully...").body(dao.saveDoctor(doctor)).build());
	}

	public ResponseEntity<?> getAllDoctorsByHid(int id) 
	{
		List<Doctor> doctor = dao.getAllDoctorsByHid(id);
		if(doctor.isEmpty())
			throw null;
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Fetched All Doctors based on Hospital id").body(doctor).build());
	}

	public ResponseEntity<?> saveDoctorByDeptAndHospId(int id, int hid, Doctor doctor) 
	{
		Optional<Hospital> hospital = hDao.findHosById(hid);
		Optional<Department> dept = dDao.findDeptById(id);
		if(hospital.isEmpty() && dept.isEmpty())
			throw InvalidIdException.builder().message("Invalid Dept and Hospital id").build();
		
		Hospital h = hospital.get();
		Department d = dept.get();
		
		doctor.setHospital(h);
		doctor.setDepartment(d);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.builder()
				.status(HttpStatus.CREATED.value()).message("Saved successfully...").body(dao.saveDoctor(doctor)).build());
	}

}
