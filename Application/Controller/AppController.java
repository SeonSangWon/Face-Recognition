package Controller;

import GUI.Application;
import Service.RestAPI;

public class AppController {

	public static void main(String[] args) {
		
		Application app = new Application();
		app.createFrame();
		
		RestAPI api = new RestAPI();
		//api.get("http://127.0.0.1:5000/user/201507046");
	}

}
