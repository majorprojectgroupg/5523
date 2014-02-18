package data;

import org.json.JSONException;
import org.json.JSONObject;

public class AdminParser extends Parser {

	// iterates over the JSONArray of questions and extracts the question information (INCOMPLETE)
	public void getQuestions() {
		try {
		 
			questions = data.getJSONArray("questions");
			
			for (int i = 0; i < questions.length(); i++) {
				
				// still requires code to extract the data from each JSONObject and send wherever
				if (((JSONObject) questions.get(i)).get("qType").equals("text")) {}
				else if (((JSONObject) questions.get(i)).get("qType").equals("number")) {}
				else if (((JSONObject) questions.get(i)).get("qType").equals("multiple")) {}
				else if (((JSONObject) questions.get(i)).get("qType").equals("date")) {} 
			}
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
