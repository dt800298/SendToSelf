import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONtoString {
	public static void main(String[]args){
		String FILE_PATH = "File.json";
		String output = "";
		String string = "";
		JSONParser parser = new JSONParser();
		try{
			Object fileObj = parser.parse(new FileReader(FILE_PATH));
			JSONObject jsonObj = (JSONObject) fileObj;
			output = jsonObj.toString();
		}
		catch(FileNotFoundException fnfe){
			System.err.println("The file "+FILE_PATH+" was not found");
			fnfe.printStackTrace();
		}
		catch(IOException ioe){
			System.err.println("And IOException occurred");
			ioe.printStackTrace();
		}
		catch(ParseException pe){
			System.err.println("JSON Simple was not able to parse the file");
			pe.printStackTrace();
		}
	}

}
