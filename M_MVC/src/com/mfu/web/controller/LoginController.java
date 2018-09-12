package com.mfu.web.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mfu.entity.Member;
import com.mfu.service.MemberService;

@Controller
public class LoginController {

	@EJB(mappedName = "ejb:/M_MVC/MemberServiceBean!com.mfu.service.MemberService")
	MemberService memServ;

	@RequestMapping("/Login")
	public ModelAndView signIn() {
		ModelAndView mv = new ModelAndView("Login.jsp");
		Member member = new Member();
		mv.addObject("member", member);
		return mv;
	}

	@RequestMapping("/loginProcess")
	public String login(HttpServletRequest request) {

		String user = request.getParameter("username");
		String password = request.getParameter("password");
		Member member;
		
		
		String adminName ="admin";
		String adminPassword = "1234";

		try {
			member = memServ.findUserandpassword(user, password);
			if (member.equals(null)) {	
				return "redirect:Login.do";
				} 
			
			else {
				request.getSession().setAttribute("idcus", member.getMemberId());
				request.getSession().setAttribute("isLogin", "yes");
				
				return "redirect:listtran.do";
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		try {
			if (adminName.equals(user) && adminPassword.equals(password)) {
				return "redirect:list.do";
				}
			}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:Login.do";
	}

	@RequestMapping("/logout")
	public String signOut(HttpServletRequest request) {
		try {
			request.getSession().putValue("isLogin", "no");
			request.getSession().removeAttribute("id");
			request.getSession().removeAttribute("userType");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:Login.do";
	}
}
