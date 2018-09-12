package mfu.com.controller;


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
	@EJB(mappedName = "ejb:/Mwallet//MemberServiceBean!com.mfu.service.MemberService")
	MemberService memServ;

	@RequestMapping("/listEmp")
	public ModelAndView listMember(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("listEmp.jsp");
		List<Member> empList;
		try {
			empList = memServ.getAllMember();
			mv.addObject("empList", empList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("/newEmp")
	public ModelAndView newMember() {
		ModelAndView mv = new ModelAndView("empForm.jsp");
		Member emp = new Member();
		mv.addObject("member", emp);
		return mv;
	}

	@RequestMapping("/saveEmp")
	public String saveEmp(@ModelAttribute("member") Member member, BindingResult result,
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
		return "redirect:listEmp.do";
	}

	@RequestMapping("/editEmp")
	public ModelAndView editEmp(HttpServletRequest request) {
		int paramId = Integer.parseInt(request.getParameter("id"));
		Member foundEmp;
		ModelAndView mv = new ModelAndView("empForm.jsp");
		try {
			foundEmp = memServ.findMember(paramId);
			mv.addObject("member", foundEmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("/deleteEmp")
	public String deleteEmp(HttpServletRequest request) {
		memServ.delete(Long.valueOf(request.getParameter("id")));
		return "redirect:listEmp.do";
	}
}
