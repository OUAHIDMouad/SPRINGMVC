package org.sid.springmvc.web;

import java.util.List;

import org.sid.springmvc.dao.PatientRepository;
import org.sid.springmvc.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientController {
	@Autowired
	private PatientRepository patientRepository;
	
	@GetMapping(path="/index")
	public String index() {
		return "index";
	}
	
	@GetMapping(path="/patients")
	public String list(Model model) {
		List<Patient> patients = patientRepository.findAll();
		model.addAttribute("patients",patients);
		return "patients";
	}
}

