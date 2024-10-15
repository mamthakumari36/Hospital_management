//package org.jsp.hms.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.jsp.hms.entity.Patient;
//import org.jsp.hms.repository.PatientRepository;
//import org.jsp.hms.responseStructure.ResponseStructure;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.PutMapping;
//
//
//@RestController
//public class PatientController 
//{
//	@Autowired
//	PatientRepository repository;
//	
//	@PostMapping("/patient")
//	public ResponseStructure<Patient> savePatient(@RequestBody Patient p)
//	{
//		repository.save(p);
//		ResponseStructure<Patient> structure = new ResponseStructure<>();
//		structure.setStatus(201);
//		structure.setMessage("Patient saved successfully");
//		structure.setBody(p);
//		return structure;
//	}
//	
//	@GetMapping("/patient")
//	public ResponseStructure<List<Patient>> findAllPatient()
//	{
//		List<Patient> p = repository.findAll();
//		
//		ResponseStructure<List<Patient>> structure = new ResponseStructure<>();
//		if(p.isEmpty())
//		{
//			structure.setStatus(404);
//			structure.setMessage("no Patient details found");
//			structure.setBody(null);
//			return structure;
//		}
//		else
//		{
//			structure.setStatus(200);
//			structure.setMessage("All Patient details found");
//			structure.setBody(p);
//			return structure;
//		}
//	}
//	
//	@GetMapping("/patient/{id}")
//	public ResponseStructure<Patient> findPatientById(@PathVariable int id)
//	{
//		Optional<Patient> optional = repository.findById(id);
//		ResponseStructure<Patient> structure = new ResponseStructure<>();
//		if(optional.isPresent())
//		{
//			Patient p = optional.get();
//			structure.setStatus(200);
//			structure.setMessage("patient details found");
//			structure.setBody(p);
//			return structure;
//		}
//		else
//		{
//			structure.setStatus(404);
//			structure.setMessage("patient not found, Invalid id...");
//			structure.setBody(null);
//			return structure;
//		}
//	}
//	
//	@DeleteMapping("/patient/{id}")
//	public ResponseStructure<String> deletePatientById(@PathVariable int id)
//	{
//		ResponseStructure<String> structure = new ResponseStructure<>();
//		Optional<Patient> optional = repository.findById(id);
//		if(optional.isPresent())
//		{
//			repository.deleteById(id);
//			structure.setStatus(200);
//			structure.setMessage("patient details deleted successfully...");
//			structure.setBody("details deleted...");
//			return structure;	
//		}
//		else
//		{
//			structure.setStatus(404);
//			structure.setMessage("patient details not found...");
//			structure.setBody("Invalid Id...");
//			return structure;	
//		}
//	}
//	
//	@PutMapping("/patient")
//	public ResponseStructure<Patient> putMethodName(@RequestBody Patient p) 
//	{
//		repository.save(p);
//		ResponseStructure<Patient> structure = new ResponseStructure<>();
//		structure.setStatus(200);
//		structure.setMessage("Patient details updated....");
//		structure.setBody(p);
//		return structure;
//	}
//}
