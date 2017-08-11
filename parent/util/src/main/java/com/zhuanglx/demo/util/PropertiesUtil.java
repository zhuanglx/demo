package com.zhuanglx.demo.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties properties = new Properties();
	private static boolean inited = false;
	public static String fileName  = "demo.properties";	
	static{
		load();
	}

	public static Properties load(){
		inited=false;
		String path = PropertiesUtil.class.getClassLoader().getResource(fileName).getPath();
		FileInputStream in;
		try {
			in = new FileInputStream(path);
			properties.load(in);
			inited=true;
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			inited=false;
		}
		
		return properties;
	}
	public static  String getValue(String key,String defaultValue){
		if(!inited){
			load();
		}
		return properties.getProperty(key, defaultValue);
	}
	public static void  setValue(String key,String value){
		
		String path = PropertiesUtil.class.getClassLoader().getResource(fileName).getPath();

	    FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(path);
			properties.setProperty(key, value);
			    try {
			    	properties.store(fileOutputStream, "save properties");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    try {
			    	fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   
	   
	    
	}
	public static void  setValue(Map<String,String> map){
		
		String path = PropertiesUtil.class.getClassLoader().getResource(fileName).getPath();

	    FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(path);
			
			 Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
			  while (it.hasNext()) {
			   Map.Entry<String, String> entry = it.next();
			   properties.setProperty(entry.getKey(), entry.getValue());
			  }
			
			    try {
			    	properties.store(fileOutputStream, "save properties");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    try {
			    	fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   
	   
	    
	}
}

