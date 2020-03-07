package com.spring.face.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	/**
	 * Method ID : join()
	 * Method 설명 : 회원가입 페이지로 이동
	 * @return
	 */
	@RequestMapping("join")
	public String join() {
		
		return "member/join";
	}
	
	/**
	 * Method ID : login()
	 * Method 설명 : 로그인 페이지로 이동
	 * @return
	 */
	@RequestMapping("login")
	public String login() {
		
		return "member/login";
	}
	
	/**
	 * Method ID : memberInsert
	 * Method 설명 : 회원의 정보를 데이터베이스에 등록한다.
	 * @param phone_1 : 전화번호 앞자리 ex) 010 / 011 / ...
	 * @parma phone_2 : 전화번호 ex) xxxx-xxxx
	 * @param memberDTO
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="memberInsert", method=RequestMethod.POST)
	public String memberInsert(MemberDTO memberDTO, Model model, HttpServletRequest request) {
		
		//초기화
		String phone_1 = "";
		String phone_2 = "";
		try {
			phone_1 = request.getParameter("phone_1");
			phone_2 = request.getParameter("phone_2");
			memberDTO.setPhone(phone_1 + phone_2);
			
			log.debug("학번 : " + memberDTO.getStudent_id());
			log.debug("이름 : " + memberDTO.getName());
			log.debug("아이디 : " + memberDTO.getId());
			log.debug("비밀번호 : " + memberDTO.getPassword());
			log.debug("전화번호 : " + memberDTO.getPhone());
			
			//회원가입
			memberService.memberInsert(memberDTO);
			log.debug("MemberController : memberInsert() Success!!");
			
		}catch(Exception e) {
			e.printStackTrace();
			log.error("MemberController : memberInsert() Error!!");
		}
		
		return "redirect:/";
	}

	/**
	 * Method ID : loginCheck
	 * Method 설명 : 홈페이지에서 ID와 PW를 입력받아 로그인을 진행한다.
	 * @param result : 로그인 결과값
	 * @param memberDTO
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/loginCheck")
	public String loginCheck(MemberDTO memberDTO, Model model, HttpSession session) {
		 
		//로그인 실패 : 0
		//로그인 성공 : 1
		//탈퇴한 사용자 : 2
		int result = 0;
		try {
			
			log.debug("아이디 : " + memberDTO.getId());
			log.debug("비밀번호 : " + memberDTO.getPassword());
		
			result = memberService.login(memberDTO, session);
			if(result == 1)
			{
				log.debug("MemberController : loginCheck() Success!!");
				log.debug("MemberController : Session : " + session.getAttribute("student_id"));
				
				//회원전용 홈페이지로 이동
				return "redirect:/";
			}
			else if(result == 99)
			{
				//관리자 페이지로 이동
				return "redirect:admin/adminMemberList";
			}
		}catch(Exception e) {
			e.printStackTrace();
			log.error("MemberController : loginCheck() Error!!");
		}
		
		return "redirect:login";
	}
	
	/**
	 * Method ID : logout()
	 * Method 설명 : 회원 로그아웃
	 * @param session
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("student_id");
		
		return "redirect:/";
	}
}
