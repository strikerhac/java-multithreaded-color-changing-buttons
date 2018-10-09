package multithreading;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class config_singelton {
	
	private static FileOutputStream config_file = null;
	private config_singelton(){}
	static String url = "F:\\Semester 5\\Advanced Programming\\Labs\\multithreading\\config.properties";
	
	public static String get_File_url(){
		if (config_file != null){
			return url;
		}
		Properties prop = new Properties();
		try {
			
			config_file = new FileOutputStream(url);

			// set the properties value
			prop.setProperty("flashTime", "1000");
			prop.setProperty("noOfItems" ,"500");

			// save properties to project root folder
			prop.store(config_file, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (config_file != null) {
				try {
					config_file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return url;
		
	}
	
}
