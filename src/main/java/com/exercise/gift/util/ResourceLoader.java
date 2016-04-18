package com.exercise.gift.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.exercise.gift.constant.GiftExchangeConstants;

public class ResourceLoader {
	
	String result = "";
	InputStream inputStream;
 
	public Properties getPropertyFile() {
		Properties prop = new Properties();
		String propFileName = GiftExchangeConstants.PROPERTY_FILE_NAME;
		
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		} catch (Exception e) {
			System.out.println("Exception while loading resource property file: " + e); //we can have logger statement 
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			
		}
		return prop;
	}
	
	/**
	 * Method to get resource property value for given property key
	 * @param key
	 * @return
	 */
	public String getProperty(String key) {
		
		return getPropertyFile().getProperty(key);
	}

}
