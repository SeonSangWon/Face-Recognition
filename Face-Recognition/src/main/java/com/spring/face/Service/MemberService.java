package com.spring.face.Service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.face.DAO.IMemberDAO;
import com.spring.face.DTO.MemberDTO;

@Service
public class MemberService implements IMemberService {
	
	@Autowired
	private IMemberDAO memberDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

	@Override
	//관리자 : 회원 전체목록 조회 [비밀번호 복호화X]
	public List<MemberDTO> adminMemberList() {
		
		return memberDAO.adminMemberList();
	}

	@Override
	//회원 : 사이트 로그인
	public int login(MemberDTO memberDTO, HttpSession session) {
		//로그인 실패 : 0
		//로그인 성공 : 1
		//탈퇴한 사용자 : 2
		int result = 0;
		MemberDTO vo = new MemberDTO();
		try {
			
			vo = memberDAO.login(memberDTO);
			
			//로그인 성공
			if(vo != null)
			{
				if(vo.getGhost().equals("n"))
				{
					//로그인 성공코드 1 부여 / 로그인 세션 생성
					result = 1;
					session.setAttribute("student_id", vo.getStudent_id());
				}
				else
				{
					result = 2;
				}
			}
			else
				result = 0;
			
			logger.debug("MemberService : result = " + result);
			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("MemberService : login() Error!!");
		}
		
		return result;
	}

	@Override
	//회원 : 정보 수정을 위한 정보 조회
	public List<MemberDTO> selectMember(MemberDTO memberDTO) {
		
		try {
			MemberDTO vo = new MemberDTO();
			String student_id = "NULL";
			
			//NullPointException 방지하기 위해 초기값 할당
			vo.setStudent_id(student_id);
			vo.setStudent_id(memberDTO.getStudent_id());
			
			logger.debug("MemberService : " + vo.getStudent_id());
			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("MemberService : selectMember() Error!!");
		}
		
		return memberDAO.selectMember(memberDTO);
	}

	@Override
	//회원 : 정보 저장
	public void memberInsert(MemberDTO memberDTO) {
		
		try {
			memberDAO.memberInsert(memberDTO);
			logger.debug("MemberService : memberInsert() Success!!");
			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("MemberService : memberInsert() Error!!");
		}
	}

	@Override
	//회원 : 정보 수정
	public void memberUpdate(MemberDTO memberDTO) {
		
		try {
			memberDAO.memberUpdate(memberDTO);
			logger.debug("MemberService : memberUpdate() Success!!");
			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("MemberService : memberUpdate() Error!!");
		}
	}

	@Override
	//회원 : 정보를 삭제하지 않고 비밀번호 난수 + 암호화 저장 후 탈퇴유무를 y로 변경하여 로그인 못하게 방지
	//얼굴인식 학습 모델은 삭제해야 함
	public void memberDelete(MemberDTO memberDTO) {
		
		try {
			memberDAO.memberDelete(memberDTO);
			logger.debug("MemberService : memberDelete() Success!!");
			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("MemberService : memberDelete() Error!!");
		}
	}
}
