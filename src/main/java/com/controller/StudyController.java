package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Patient;
import com.model.Study;
import com.service.PatientService;
import com.service.PatientServiceImpl;
import com.service.StudyService;
import com.service.StudyServiceImpl;

@Controller
public class StudyController {

	@RequestMapping(value = "/study", method = RequestMethod.GET)
	public ModelAndView getAllStudy() {

		System.out.println("GetAllStudy();");

		StudyService studyService = new StudyServiceImpl();
		List<Study> study = studyService.getAllStudy();

		PatientService ps = new PatientServiceImpl();
		List<Patient> list = ps.getAllPatients();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("study.jsp");
		mv.addObject("study_list", study);

		mv.addObject("list", list);

		return mv;
	}

	@RequestMapping(value = "/study", method = RequestMethod.POST)
	public ModelAndView addStudy(@RequestParam("pid") String pid, @RequestParam("room") int room,
			@RequestParam("description") String desc, @RequestParam("start_time") int start_time,
			@RequestParam("end_time") int end_time) {

		ModelAndView mv = new ModelAndView();
		// System.out.println("Room: " + room + "--" + desc + "--" + start_time);
		StudyService ps = new StudyServiceImpl();
		String sid = ps.addStudy(pid, desc, start_time, end_time, room);

		mv.setViewName("study.jsp");
		mv.addObject("study_id", sid);
		return mv;
	}

	@RequestMapping(value = "/updatestatus", method = RequestMethod.POST)
	public ModelAndView updateStudy(@RequestParam("studyid") String studyid) {

		System.out.println("/updatestatus is called.... with studyid: " + studyid);
		ModelAndView mv = new ModelAndView();

		StudyService ps = new StudyServiceImpl();
		System.out.println(ps.updateStatus(studyid));
		mv.setViewName("redirect: study");

		return mv;
	}

//	@RequestMapping(value = "/study", method = RequestMethod.POST)
//	// @RequestBody Study study,
//	public ModelAndView addStudy(HttpServletRequest request) throws ServletException, IOException {
//		System.out.println("Controller /study is called via addStudy();");
//
//		String jsonData = request.getParameter("t1");
//		System.out.println(jsonData);
//
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("study.jsp");
//
//		return mv;
//	}

//	private List<Study> convertToStudyList(String str) {
//		List<Study> ls = new ArrayList<Study>();
//		try {
//			JSONObject jsonObject = new JSONObject(str);
//			JSONArray getArray = jsonObject.getJSONArray("cars");
//			for (int i = 0, size = getArray.length(); i < size; i++) {
//				System.out.println(getArray.get(i));
//			}
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ls;
//
//	}
}
