package org.jsp.hms.dao;

import java.util.Optional;

import org.jsp.hms.entity.Hospital;
import org.jsp.hms.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HospitalDao 
{
	@Autowired
	 HospitalRepository repository;

	public Object saveHospital(Hospital hospital) 
	{
		return repository.save(hospital);
	}

	public Object getAllHospital() 
	{
		return repository.findAll();
	}

	public Optional<Hospital> findHosById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	public Hospital updateHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		return repository.save(hospital);
	}

	public void deleteHospitalById(int id) 
	{
		 repository.deleteById(id);
	}

//	public Optional<Hospital> findHospitalById(int id) {
//		// TODO Auto-generated method stub
//		return repository.findById(id);
//	}

}
