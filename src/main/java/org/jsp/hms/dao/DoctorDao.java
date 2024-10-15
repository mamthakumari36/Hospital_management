package org.jsp.hms.dao;

import java.util.List;

import org.jsp.hms.entity.Doctor;
import org.jsp.hms.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorDao 
{
	@Autowired
	DoctorRepository repository;

	public Object saveDoctor(Doctor doctor) 
	{
		return repository.save(doctor);
	}

	public List<Doctor> getAllDoctorsByHid(int id) {
		// TODO Auto-generated method stub
		return repository.getAllDoctorsByHid(id);
	}

}
