package com.spring.face.Util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Face_Recognition implements IFace_Recognition {

	private static final Logger log = LoggerFactory.getLogger(Face_Recognition.class);
	
	@Override
	public void faceInsert(String student_id) {
		
		String s = null;
		try {
			log.debug("Run Facial_Recognition_Part1.py");
			
			String path = "C:\\Python\\face\\Facial_Recognition_Part1.py";
			
			String[] cmd = new String[3];
			cmd[0] = "Python";
			cmd[1] = path;
			cmd[2] = student_id;
			
			Process process = Runtime.getRuntime().exec(cmd);
			
			BufferedReader stdInput = new BufferedReader(new
					InputStreamReader(process.getInputStream()));
			
			BufferedReader stdError = new BufferedReader(new
					InputStreamReader(process.getErrorStream()));
			
			while((s = stdInput.readLine()) != null)
			{
				System.out.println(s);
			}
			
			while((s = stdError.readLine()) != null)
			{
				System.out.println(s);
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error("Face_Recognition : faceInsert() Error!!");
			
			System.exit(-1);
		}finally {
			log.debug("Face_Recognition : faceInsert() Success!!");
			log.debug("Face_Recognition : [" + student_id + "] Colleting Face Model Complete!!");
		}
	}

	@Override
	public void faceDelete(String sutdent_id) {
		// TODO Auto-generated method stub

	}

}
