package com.spring.face.Controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.face.Util.Face_Recognition;

@Controller
public class UtilController {

	private static final Logger log = LoggerFactory.getLogger(UtilController.class);
	Face_Recognition Face_Recognition = new Face_Recognition();;
	
	@RequestMapping("faceInsert")
	public String faceInsert(HttpSession session) {
		
		String student_id = "";
		try {
		
			student_id = session.getAttribute("student_id").toString();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			log.error("");
		}
		
		return "member/join";
	}
}
