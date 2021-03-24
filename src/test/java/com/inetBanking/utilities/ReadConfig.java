package com.inetBanking.utilities;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	public static String readPropertyFileData(String keyName) {
		String redarValue = null;
		
		
		Properties properties = null;
		try {
			FileReader fileReader =new FileReader("./Configration/config.properties");
			
			properties= new Properties();
			properties.load(fileReader);
			redarValue=properties.getProperty(keyName).toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return redarValue;
		
		
	}

}
