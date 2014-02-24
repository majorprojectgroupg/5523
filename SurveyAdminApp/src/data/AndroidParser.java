package data;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;

public class AndroidParser extends Parser {

	
	public AndroidParser(File datafile) {
		super(datafile);
	}
	
	// iterates over the JSONArray of questions and extracts the question information (INCOMPLETE)
	public void getQuestions() {
		try {
			
			questions = data.getJSONArray("questions");		
			
			for (int i = 0; i < questions.length(); i++) {
				
				// still requires code to extract the data from each JSONObject and send wherever
				if (((JSONObject) questions.get(i)).get("type").equals("text")) {}
				else if (((JSONObject) questions.get(i)).get("type").equals("number")) {}
				else if (((JSONObject) questions.get(i)).get("type").equals("multiple")) {}
				else if (((JSONObject) questions.get(i)).get("type").equals("date")) {} 
				
				// this line is just for debugging; delete it later
				System.out.println(((JSONObject) questions.get(i)).get("prompt"));
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// once the patient's completed the questionnaire, this pulls the answers from the questionnaire
	// widgets and adds them to the questionnaire object
	public void setAnswers() {				
					
		for (int i = 0; i < questions.length(); i++) {
				
			// declare a local variable, assign it using the corresponding question's widget from
			// the questionnaire; still needs to be implemented
				
			// add the answer to the corresponding question (VALUE is a placeholder, update this when
			// the UI has been built
			// ((JSONObject) questions.get(i)).put("answer", VALUE);
		}
			
	}
}
