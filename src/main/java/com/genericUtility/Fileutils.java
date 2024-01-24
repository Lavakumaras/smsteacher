package com.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This methos is used to read data from property file
 * 
 * @author admin
 * @reurn
 * @param key
 * @throws Throwable
 */
public class Fileutils {
	public String readDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.FilePath);

		Properties p = new Properties();

		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

}
