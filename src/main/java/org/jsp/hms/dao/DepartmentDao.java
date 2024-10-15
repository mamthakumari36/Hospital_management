package org.jsp.hms.dao;


import java.util.List;
import java.util.Optional;

import org.jsp.hms.entity.Department;
import org.jsp.hms.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentDao 
{
	@Autowired
	private DepartmentRepository repository;

	public Object saveDepartment(Department department) 
	{
		return repository.save(department);
	}

	public List<Department> getDeptByHospId(int id) 
	{
		return repository.getDeptByHospId(id);
	}

	public Optional<Department> findDeptById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

}
