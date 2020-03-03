package com.spring.face.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.face.DTO.MemberDTO;
import com.spring.face.Service.IMemberService;

@Controller
public class AdminController {

	@Autowired
	private IMemberService memberService;
	
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	
	//관리자 메인 홈페이지
	@RequestMapping("admin")
	public String adminPage() {
		
		return "/admin/home";
	}
	
	//관리자 : 회원 전체목록 조회 [비밀번호 복호화X]
	@RequestMapping("admin/adminMemberList")
	public String adminMemberList(MemberDTO memberDTO, Model model) {
		
		try {
			model.addAttribute("adminMemberList", memberService.adminMemberList());
			log.debug("AdminController : adminMemberList() Success!!");
			
		}catch(Exception e) {
			e.printStackTrace();
			log.error("AdminController : adminMemberList() Error!!");
		}
		
		return "/admin/adminMemberList";
	}
}
