package com.spring.face.Controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.face.DTO.MemberDTO;
import com.spring.face.Service.IMemberService;

@Controller
public class MemberController {

	@Autowired
	private IMemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("signup")
	public String signUp() {
		
		return "member/signup";
	}
	
	@RequestMapping("signin")
	public String signIn() {
		
		return "home";
	}
	
	//회원 : 정보 저장
	@RequestMapping(value="memberInsert", method=RequestMethod.POST)
	public String memberInsert(MemberDTO memberDTO, Model model, HttpServletRequest request) {
		
		//초기화
		String phone_1 = "";
		String phone_2 = "";
		try {
			phone_1 = request.getParameter("phone_1");
			phone_2 = request.getParameter("phone_2");
			memberDTO.setPhone(phone_1 + phone_2);
			
			logger.debug("학번 : " + memberDTO.getStudent_id());
			logger.debug("이름 : " + memberDTO.getName());
			logger.debug("아이디 : " + memberDTO.getId());
			logger.debug("비밀번호 : " + memberDTO.getPassword());
			logger.debug("전화번호 : " + memberDTO.getPhone());
			
			//회원가입
			memberService.memberInsert(memberDTO);
			logger.debug("MemberController : memberInsert() Success!!");
			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("MemberController : memberInsert() Error!!");
		}
		
		return null;
	}
}
