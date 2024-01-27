package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson {

	public String[] read_json() throws IOException, ParseException {
		// initialize variables
		FileReader fr = null;
		JSONParser json_parser = new JSONParser();
		Object object = null;
		JSONObject json_object = null;
		JSONArray json_array;
		String[] st;
		// read file
		fr = new FileReader(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "wrong_data.json");
		// parse file as an object
		object = json_parser.parse(fr);
		// convert file into json object
		json_object = (JSONObject) object;
		// get the value of data key that holds info
		json_array = (JSONArray) json_object.get("data");
		st = new String[json_array.size()];
		// iterate through all objects and get the required values
		for (int i = 0; i < json_array.size(); i++) {
			JSONObject obj = (JSONObject) json_array.get(i);
			String username = String.valueOf(obj.get("username"));
			String pass = String.valueOf(obj.get("password"));
			st[i] = username + "," + pass;
		}
		return st;

	}
}
