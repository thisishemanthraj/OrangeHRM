package com.hrm.orange.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileLibrary
{
	public static String getDataFromPropertyFile(String filePath, String key)
	{
		String data = null;
		try
		{
			FileInputStream f1 = new FileInputStream(filePath);
			Properties prop = new Properties();
			prop.load(f1);
			data=prop.getProperty(key);
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return data;
	}
}
