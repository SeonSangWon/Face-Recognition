package com.spring.face.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.face.DTO.MemberDTO;

@Repository
public class MemberDAO implements IMemberDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDTO.class);
	private static final String Namespace = "com.spring.mapper.memberMapper";
	
	@Override
	//관리자 : 회원 전체목록 조회 [비밀번호 복호화X]
	public List<MemberDTO> adminMemberList() {

		return sqlSession.selectList(Namespace+".adminMemberList");
	}

	@Override
	//회원 : 사이트 로그인
	public int login(MemberDTO memberDTO) {
		
		int result = 0;
		
		result = sqlSession.selectOne(Namespace+".login", memberDTO);
		if(memberDTO.getGhost().equals("y"))
			result = 2;
		
		//2 : 탈퇴한 사용자
		//1 : 로그인 성공
		//0 : 로그인 실패
		logger.debug("MemberDAO : resutlt = " + result);
		return result;
	}

	@Override
	//회원 : 정보 수정을 위한 정보 조회
	public List<MemberDTO> selectMember(MemberDTO memberDTO) {
		
		MemberDTO vo = new MemberDTO();
		String student_id = "NULL";
		
		//NullPointException 방지하기 위해 초기값 할당
		vo.setStudent_id(student_id);
		vo.setStudent_id(memberDTO.getStudent_id());
		
		
		logger.debug("MemberDAO : " + vo.getStudent_id());
		return sqlSession.selectList(Namespace+".selectMember", memberDTO);
	}

	@Override
	//회원 : 정보 저장
	public void memberInsert(MemberDTO memberDTO) {

		sqlSession.insert(Namespace+".memberInsert", memberDTO);
		logger.debug("MemberDAO : memberInsert() Success!!");
	}

	@Override
	//회원 : 정보 수정 
	public void memberUpdate(MemberDTO memberDTO) {
		
		sqlSession.update(Namespace+".memberUpdate", memberDTO);
		logger.debug("MemberDAO : memberUpdate() Success!!");
	}

	@Override
	//회원 : 정보를 삭제하지 않고 비밀번호 난수 + 암호화 저장 후 탈퇴유무를 y로 변경하여 로그인 못하게 방지
	//얼굴인식 학습 모델은 삭제해야 함
	public void memberDelete(MemberDTO memberDTO) {
		
		sqlSession.update(Namespace+".memberDelete", memberDTO);
		logger.debug("MemberDAO : memberDelete() Success!!");
	}

}
