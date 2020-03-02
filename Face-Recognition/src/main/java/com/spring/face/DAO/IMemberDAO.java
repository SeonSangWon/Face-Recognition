package com.spring.face.DAO;

import java.util.List;

import com.spring.face.DTO.MemberDTO;

public interface IMemberDAO {

	//관리자 : 회원 전체목록 조회 [비밀번호 복호화X]
	public List<MemberDTO> adminMemberList();
	//회원 : 사이트 로그인
	public MemberDTO login(MemberDTO memberDTO);
	//회원 : 정보 수정을 위한 정보 조회
	public List<MemberDTO> selectMember(MemberDTO memberDTO);
	//회원 : 정보 저장
	public void memberInsert(MemberDTO memberDTO);
	//회원 : 정보 수정 
	public void memberUpdate(MemberDTO memberDTO);
	//회원 : 정보를 삭제하지 않고 비밀번호 난수 + 암호화 저장 후 탈퇴유무를 y로 변경하여 로그인 못하게 방지
	//얼굴인식 학습 모델은 삭제해야 함
	public void memberDelete(MemberDTO memberDTO);
}
