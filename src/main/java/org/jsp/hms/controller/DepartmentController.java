package org.jsp.hms.controller;

import org.jsp.hms.entity.Department;
import org.jsp.hms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController 
{
	@Autowired
	private DepartmentService service;
	
	@PostMapping("/hid/{hid}")
	public ResponseEntity<?> saveDepartment(@PathVariable int hid , @RequestBody Department department)
	{
		return service.saveDepartment(hid,department);
	}

	@GetMapping("/hid/{hid}")
	public ResponseEntity<?> getDeptByHospId(@PathVariable int hid)
	{
		return service.getDeptByHospId(hid);
	}
}
