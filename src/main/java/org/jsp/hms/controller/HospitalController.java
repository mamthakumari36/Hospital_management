package org.jsp.hms.controller;

import org.jsp.hms.entity.Hospital;
import org.jsp.hms.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/hospital")
public class HospitalController 
{
	@Autowired
	private HospitalService service;
	
	@PostMapping
	public ResponseEntity<?> saveHospital(@RequestBody Hospital hospital)
	{
		return service.saveHospital(hospital);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllHospital()
	{
		return service.getAllHospital();
	}
	
	@PutMapping("/{hid}")
	public ResponseEntity<?> updateHospital(@PathVariable int hid, @RequestBody Hospital hospital) 
	{	
		return service.updateHospital(hid,hospital);
	}
	
	@DeleteMapping("/{hid}")
	public ResponseEntity<?> deleteHospitalById(@PathVariable int hid)
	{
		return service.deleteHospitalById(hid);
	}
	
	
}
