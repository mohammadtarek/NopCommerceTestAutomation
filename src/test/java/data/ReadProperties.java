package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ReadProperties {
	public static Properties userData=properties(System.getProperty("user.dir")+"\\src\\main\\java\\Properities\\userdata.properties");
	
	private static Properties properties (String path) {
		
		Properties pro=new Properties();
		FileInputStream stream;
		try {
			stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println("Error: "+e.getMessage()); ;
		}catch (IOException e) {
			
			System.out.println("Error: "+e.getMessage()); ;
		}
		return pro;
	}

}
