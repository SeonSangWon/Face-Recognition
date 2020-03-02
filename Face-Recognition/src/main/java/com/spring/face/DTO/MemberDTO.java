package com.spring.face.DTO;

import java.sql.Timestamp;

public class MemberDTO {

	private String student_id;			//학번
	private String id;					//학교포털ID
	private String password;			//학교포털PW
	private String name;				//이름
	private String phone;				//전화번호
	private String ghost;				//탈퇴유무
	private Timestamp create_date;		//가입일자
	private Timestamp modified_date;	//DB변경일자
	
	
	//Getter, Setter
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGhost() {
		return ghost;
	}
	public void setGhost(String ghost) {
		this.ghost = ghost;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public Timestamp getModified_date() {
		return modified_date;
	}
	public void setModified_date(Timestamp modified_date) {
		this.modified_date = modified_date;
	}
}
