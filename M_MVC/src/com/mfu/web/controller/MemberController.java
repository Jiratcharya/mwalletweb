package com.mfu.web.controller;


import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mfu.entity.Member;
import com.mfu.service.MemberService;



@Controller
public class MemberController {
	@EJB(mappedName = "ejb:/M_W//MemberServiceBean!com.mfu.service.MemberService")
	MemberService memServ;
	
	@RequestMapping("/list")
	public ModelAndView listMember(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("list.jsp");
		List<Member> list;
		try {
			list = memServ.getAllMember();
			mv.addObject("listmem", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	} 

	@RequestMapping("/regis")
	public ModelAndView newMember() {
		ModelAndView mv = new ModelAndView("regis.jsp");
		Member member = new Member();
		mv.addObject("member",  member);
		return mv;
	}

	@RequestMapping("/saveMem")
	public String saveMem(@ModelAttribute("member") Member member, BindingResult result,
			HttpServletRequest request) {
		// System.out.println("saving "+member.getFirstname()+"
		// "+member.getLastname());
		try {
			// member is not existed, meaning it's new member
			if (member.getMemberId() == 0) {
				memServ.insert(member);
				// member is existed
			} else {
				memServ.update(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:list.do";
	}

	@RequestMapping("/memForm")
	public ModelAndView editMem(HttpServletRequest request) {
		int paramId = Integer.parseInt(request.getParameter("id"));
		Member foundMem;
		ModelAndView mv = new ModelAndView("memForm.jsp");
		try {
			foundMem = memServ.findMember(paramId);
			mv.addObject("member", foundMem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("/deleteMem")
	public String deleteMem(HttpServletRequest request) {
		memServ.delete(Long.valueOf(request.getParameter("id")));
		return "redirect:list.do";
	}
	
	
	@RequestMapping("/budget")
	public ModelAndView editbudget(HttpServletRequest request) {
		int paramId = Integer.parseInt(request.getParameter("id"));
		Member foundMem;
		ModelAndView mv = new ModelAndView("View_budget.jsp");
		try {
			foundMem = memServ.findMember(paramId);
			mv.addObject("member", foundMem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}	
	
	
	
	@RequestMapping("/finduser")
	public ModelAndView finduser (HttpServletRequest request) {
		List<Member> finduser;
		ModelAndView mv = new ModelAndView("SearchUser.jsp");
		String name = request.getParameter("name");
		try {
			finduser = memServ.findMemberFirstname(name);
			mv.addObject("finduser", finduser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
}
