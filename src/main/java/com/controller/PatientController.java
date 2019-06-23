package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Patient;
import com.service.PatientService;
import com.service.PatientServiceImpl;

@Controller
public class PatientController {

	@RequestMapping(value = "/patients", method = RequestMethod.POST)
	public ModelAndView addPatiexnt(@RequestParam("name") String name, @RequestParam("sex") String sex,
			@RequestParam("dob") String dob) {
		System.out.println("Controller /patient is called via addPatient();");
		PatientService ps = new PatientServiceImpl();
		String id = ps.addPatient(name, sex, dob);
		System.out.println("Generated Patient id: " + id);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		mv.addObject("patient_id", id);

		return mv;
	}

	@RequestMapping(value = "/patients", method = RequestMethod.GET)
	public ModelAndView getPatients() {
		System.out.println("Controller /patients is called via getPatients();");
		PatientService ps = new PatientServiceImpl();
		List<Patient> list = ps.getAllPatients();

		/*
		 * for (Patient p : list) { System.out.println(p.getId() + " " + p.getSex() +
		 * " " + p.getName() + " " + p.getDateOfBirth()); }
		 */
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");

		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping(value = "/patients/{id}", method = RequestMethod.GET)
	public ModelAndView getPatientById(@PathVariable("id") String id) {
		System.out.println("Controller /patients/" + id + " is called via getPatientById();");
		PatientService ps = new PatientServiceImpl();
		Patient p = ps.getPatientById(id);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("study.jsp");
		mv.addObject("patient", p);
		return mv;

	}

}
