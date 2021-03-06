package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
		questions = new JSONArray();
	}
	
	public Parser(File datafile) {
		setData(datafile);		
	}
	
	// reads a textfile line by line, appends each line to a String, then populates the "data" and
	// "questions" objects
	public void setData(File datafile) {				
		try {
			BufferedReader reader = new BufferedReader(new FileReader(datafile));
			String line = null;
			String datafeed = new String();
			
			while ((line = reader.readLine()) != null) {
				datafeed += line;
			}
			
			reader.close();		 
			
			try {
				data = (JSONObject) new JSONTokener(datafeed).nextValue();
			} catch (JSONException e) {
				e.printStackTrace();
			}			
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}				
		
		try {
			questions = data.getJSONArray("questions");
		} catch (JSONException e) {
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
	
	// clears questionnaire and answers from app (find a way to make this more explicit)
	public void deleteAllData() {
		data = null;
		questions = null;
		System.gc();
	}
}
