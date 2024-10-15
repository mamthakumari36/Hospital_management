package org.jsp.hms.controller;


import org.jsp.hms.entity.Doctor;
import org.jsp.hms.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController 
{
	@Autowired
	private DoctorService service;
	
	@PostMapping("/{hid}")
	public ResponseEntity<?> saveDoctor(@PathVariable int hid, @RequestBody Doctor doctor)
	{
		return service.saveDoctor(hid,doctor);
	}
	
	@PostMapping("/did/{id}/hid/{hid}")
	public ResponseEntity<?> saveDoctorByDeptAndHospId(@PathVariable int id,@PathVariable int hid,@RequestBody Doctor doctor)
	{
		return service.saveDoctorByDeptAndHospId(id,hid,doctor);
	}
	
	@GetMapping("/hid/{hid}")
	public ResponseEntity<?> getAllDoctorsByHid(@PathVariable int hid) 
	{
		return service.getAllDoctorsByHid(hid);
	}
	

}
