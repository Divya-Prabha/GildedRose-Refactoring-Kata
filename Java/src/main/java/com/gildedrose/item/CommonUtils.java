package main.java.com.gildedrose.item;

import java.util.ResourceBundle;

public class CommonUtils {
	
	//public final static Map<String, String> properties = new HashMap<>();
	
	//@PostConstruct
	public  String getResources(String key){
	
		String fileName = "src\\main\\resources\\glidedRoses\\Commons.properties";
		
		final ResourceBundle bundle = ResourceBundle.getBundle(fileName);
		
		final String value = bundle.getString(key);
		
		return value;
		
		/*
		 * for(final Enumeration<String> keys =
		 * bundle.getKeys();keys.hasMoreElements();) { final String key =
		 * keys.nextElement(); final String value = bundle.getString(key);
		 * properties.put(key, value); }
		 */
	}
	
}
