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
public abstract class Parser {

	protected JSONObject data; 			// this is the whole questionnaire
	protected JSONArray questions;		// this is just the array of questions, without patient data
	
	public Parser() {
		data = new JSONObject();
	}
	
	public Parser(String datafeed) {
		
		try {
			data = (JSONObject) new JSONTokener(datafeed).nextValue();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// parses the questionnaire into a usable format
	public void setData(String datafeed) {
		try {
			data = (JSONObject) new JSONTokener(datafeed).nextValue();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public String getPatientFirstname() {
		try {
			return data.getString("firstname");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error: JSONException";
		}
	}
	
	public String getPatientLastname() {
		try {
			return data.getString("lastname");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error: JSONException";
		}
	}
	
	public String getPatientBirthdate() {
		try {
			return data.getString("birthdate");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error: JSONException";
		}
	}
	
	// iterates over the JSONArray of questions and extracts the question information
	// defined by subclass
	public abstract void getQuestions();		
	
	// for sending the question data in the form of a String
	public String getData() {
		return data.toString(); 
	}
}
