import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Client {
	public static void main(String[]args){
		String FILE_PATH = "File.json";
		String a = "";
		JSONParser parser = new JSONParser();
		try{
			Object fileObj = parser.parse(new FileReader(FILE_PATH));
			JSONObject jsonObj = (JSONObject) fileObj;
			a = jsonObj.toString();
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
	      try {
	          Socket skt = new Socket("10.5.48.78", 5801);
	          System.out.print("Server has connected!\n");
		         PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
		         System.out.print("Sending string: '" + a + "'\n");
		         out.print(a);
		         out.close();
		         skt.close();
	       }
	       catch(Exception e) {
	          System.out.print("Whoops! It didn't work!\n");
	       }
	      
	}
}
