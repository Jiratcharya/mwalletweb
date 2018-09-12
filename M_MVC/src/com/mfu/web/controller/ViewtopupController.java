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
	import com.mfu.entity.Topup;
	import com.mfu.service.MemberService;
	import com.mfu.service.TopupService;

	@Controller
	public class ViewtopupController {
		@EJB(mappedName = "ejb:/M_W//TopupServiceBean!com.mfu.service.TopupService")
		TopupService topServ;
		@EJB(mappedName = "ejb:/M_W//MemberServiceBean!com.mfu.service.MemberService")
		MemberService memServ;
		

		@RequestMapping("/Viewtopup")
		public ModelAndView newMember() {
			ModelAndView mv = new ModelAndView("Viewhistory_topup.jsp");
			Member member = new Member();
			mv.addObject("member",  member);
			return mv;
			}
//		@RequestMapping("/find")
//		public ModelAndView finduser (HttpServletRequest request) {
//			List<Member> finduser;
//			ModelAndView mv = new ModelAndView("findtopup.jsp");
//			String name = request.getParameter("name");
//			try {
//				finduser = memServ.findMemberFirstname(name);
//				mv.addObject("finduser", finduser);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return mv;
//		}
	//	
		@RequestMapping("/saveHistoryTopup")
		public String saveBalance(@ModelAttribute("Topup") Topup Topup, BindingResult result,
				HttpServletRequest request) {
			// System.out.println("saving "+Topup.getFirstname()+"
			// "+Topup.getLastname());
			try {
				// Topup is not existed, meaning it's new Topup
				if (Topup.getTopupId() == 0) {
					topServ.insert(Topup);
					// Topup is existed
				} else {
					topServ.update(Topup);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:Viewhistory_topup.do";

		}
	}


