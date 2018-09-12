package com.mfu.web.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.mfu.entity.Transac;
import com.mfu.service.MemberService;
import com.mfu.service.TransacService;




@Controller
public class TransacController {

	@EJB(mappedName = "ejb:/M_MVC/TransacServiceBean!com.mfu.service.TransacService")
	TransacService TanServ;
	
	@RequestMapping("/InsertTran")
	public ModelAndView InsertTran() {
		ModelAndView mv = new ModelAndView("InsertTran.jsp");
		Transac transac = new Transac();
		mv.addObject("transac",transac);
		return mv;
	}
	
	@RequestMapping("/saveTransac")
	public String saveTransac(@ModelAttribute("transac") Transac transac, BindingResult result, HttpServletRequest request){
		try {
			if (transac.getTransacId() == 0){
				TanServ.insert(transac);
			}else{
				TanServ.update(transac);
			}
		}catch (Exception e){
		}return "redirect:listtran.do";
	}
	
	
	@RequestMapping("/delete")
	public String deleteAppointment(HttpServletRequest request){
		TanServ.delete(Long.valueOf(request.getParameter("id")));
		return "redirect:listtran.do";
	
	}
	
	@RequestMapping("/listtran")
	public ModelAndView listAppointment(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("listtran.jsp");
		List<Transac> listtran;
		try {
			listtran = TanServ.getAllTransac();
			mv.addObject("Listtran", listtran);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
}
