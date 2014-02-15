package ui;

import org.json.JSONException;
import org.json.JSONObject;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//new LoginDemo().setVisible(true);
		//new AdminFrameBasicDemo().setVisible(true);

		//jTest();		
	}

	public static void jTest() {
		JSONObject jo = new JSONObject();
		
		try {
			jo.put("qType", "text");
			jo.put("qText", "How does this make you feel?");
			jo.put("qAnswer", "not very well");
		} catch (JSONException je) {}
		
		System.out.println(jo.toString());
		
	}
	
}
