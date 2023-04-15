package data;



import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;




public class JsonDataReader {
	
	
	public String   fName="fsd",lName="fsda",email="sdf",password="asdf";

	public void jsonReader() throws IOException {
		
	String filePath=System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.json";
	
	File srcFile=new File(filePath);
	
	JsonParser parser=new JsonParser();
	JsonArray jArray=(JsonArray)parser.parse(new FileReader(srcFile));
	
	for (Object jsonObj:jArray)
	{
		JsonObject person =(JsonObject) jsonObj;
		 fName=  person.get("fName").toString();
		 System.out.println(fName);
		 lName=  person.get("lName").toString();
		 System.out.println(lName);
		 email=  person.get("email").toString();
		 System.out.println(email);
		 password=  person.get("password").toString();
		 System.out.println(password);
		 
	}
	}
	

}
