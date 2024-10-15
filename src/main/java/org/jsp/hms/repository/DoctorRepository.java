package org.jsp.hms.repository;

import java.util.List;

import org.jsp.hms.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	@Query("select d from Doctor d where d.hospital.hid = ?1")
	List<Doctor> getAllDoctorsByHid(int id);

}
