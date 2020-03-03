package com.spring.face.Util;

public interface IFace_Recognition {

	//회원 : 얼굴 등록
	public void faceInsert(String student_id);
	//회원 : 얼굴 삭제
	public void faceDelete(String sutdent_id);
}
