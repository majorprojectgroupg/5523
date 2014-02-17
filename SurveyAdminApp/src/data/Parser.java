package data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/*
 * Questionnaire format:
 * {
 *   "lastname": string
 *   "firstname": string
 *   "birthdate": string
 *   "questions" : JSONArray 
 * }
 */
public class Parser {

	JSONObject data;
	JSONArray questions;
	
	public Parser() {
		data = new JSONObject();
	}
	
	public Parser(String datafeed) throws JSONException {
		data = (JSONObject) new JSONTokener(datafeed).nextValue();
	}
	
	// parses the questionnaire into a usable format
	public void setData(String datafeed) throws JSONException {
		data = (JSONObject) new JSONTokener(datafeed).nextValue();
	}
		
	public String getPatientFirstname() throws JSONException {
		return data.getString("firstname");
	}
	
	public String getPatientLastname() throws JSONException {
		return data.getString("lastname");
	}
	
	public String getPatientBirthdate() throws JSONException {
		return data.getString("birthdate");
	}
	
	// iterates over the JSONArray of questions and extracts the question information (INCOMPLETE)
	public void getQuestions() throws JSONException {
		questions = data.getJSONArray("questions");
		
		for (int i = 0; i < questions.length(); i++) {
			
			// still requires code to extract the data from each JSONObject and populate the
			// UI's questionnaire
			if (((JSONObject) questions.get(i)).get("qType").equals("text")) {}
			else if (((JSONObject) questions.get(i)).get("qType").equals("number")) {}
			else if (((JSONObject) questions.get(i)).get("qType").equals("multiple")) {}
			else if (((JSONObject) questions.get(i)).get("qType").equals("date")) {} 
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
			((JSONObject) questions.get(i)).put("answer", VALUE);
		}
		
	}
	
	// now that the answers have been added to the questionnaire, the data can be sent back to the
	// survey administration app
	public String getData() {
		return data.toString(); 
	}
}
