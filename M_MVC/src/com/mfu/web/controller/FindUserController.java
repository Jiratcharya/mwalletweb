package com.mfu.web.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transaction;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.mfu.entity.Member;
import com.mfu.entity.Topup;
import com.mfu.service.MemberService;
import com.mfu.service.TopupService;

@Controller
public class FindUserController {
	@EJB(mappedName = "ejb:/M_W//TopupServiceBean!com.mfu.service.TopupService")
	TopupService topServ;
	@EJB(mappedName = "ejb:/M_W//MemberServiceBean!com.mfu.service.MemberService")
	MemberService memServ;
	
	@RequestMapping("/findtopup")
	public ModelAndView newMember() {
		ModelAndView mv = new ModelAndView("findtopup.jsp");
		Member member = new Member();
		mv.addObject("member",  member);
		return mv;
	}
//	
//	@RequestMapping("/findtopupProcess")
//	public List<String> search (String username){
//		List<String> result = null;
//		Member member = new Member(); 
//		try {
//			member = memServ.findUser(username);
//			if (member.equals(null)) {	
//				return "findtopup.do";
//				} 
//			
//			else {
//				
//				return "Topup.do";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
//		return "findtopup.do";
//	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	public String index() {
//		return "redirect:findtopup.do";
//	}
//	
//	@RequestMapping("/findtopupProcess")
//	public String contactSearch(Model m ,HttpSession session) {
//		try {String username = (String) session.getAttribute("username");
//	
//		m.addAttribute("memberlist" , memServ.findUser(username));
//		if (username.equals(null)) {
//			return "redirect:findtopup.do";
//			
//			} 
//		
//		else {
//			return "redirect:Topup.do";
//		}
//	} 
//	catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	return "redirect:findtopup.do";
//	}
	

//	@RequestMapping("/findtopupProcess")
//	public String login(HttpServletRequest request) {
//
//		String user = request.getParameter("username");
//		Member member;
//		
//		try {
//			member = memServ.findUser(user);
//			if (member.equals(null)) {	
//				return "redirect:findtopup";
//				} 
//			
//			else {
//				request.getSession().setAttribute("idcus", member.getMemberId());
//				request.getSession().setAttribute("isLogin", "yes");
//				
//				return "redirect:Topup.do";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
//		return "redirect:Topup.do";
//	}

//	@RequestMapping("/findtopupProcess")
//	public ModelAndView finduser (HttpServletRequest request) {
//		Member finduser;
//		ModelAndView mv = new ModelAndView("findtopup.jsp");
//		String username = request.getParameter("username");
//		try {
//			finduser = memServ.findUser(username);
//			mv.addObject("finduser", finduser);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return mv;
//	}


//	@RequestMapping("/saveuser")
//	public String saveBalance(@ModelAttribute("Topup") Topup Topup, BindingResult result,
//			HttpServletRequest request) {
//		// System.out.println("saving "+Topup.getFirstname()+"
//		// "+Topup.getLastname());
//		try {
//			// Topup is not existed, meaning it's new Topup
//			if (Topup.getTopupId() == 0) {
//				topServ.insert(Topup);
//				// Topup is existed
//			} else {
//				topServ.update(Topup);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "redirect:Topup.do";
//
//	}
}
