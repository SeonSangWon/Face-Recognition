package com.spring.face.Controller;

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
	
	//회원 : 정보 저장
	@RequestMapping(value="memberInsert", method=RequestMethod.POST)
	public String memberInsert(MemberDTO memberDTO, Model model) {
		
		try {
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
