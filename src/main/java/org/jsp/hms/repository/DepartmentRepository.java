package org.jsp.hms.repository;

import java.util.List;

import org.jsp.hms.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	@Query("select d from Department d where d.hospital.hid = ?1")
	List<Department> getDeptByHospId(int id);

}
