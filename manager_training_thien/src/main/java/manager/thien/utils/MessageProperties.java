/**
 * Copyright(C) 2016 Luvina Software Company
 * MessageProperties.java Sep 16, 2016 nguyenducthien
 */
package manager.thien.utils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Dùng để lấy message từ file message.properties
 * @author nguyenducthien
 *
 */
@SuppressWarnings("unchecked")
public class MessageProperties {

	 static private Map<String, String> data = new HashMap<String, String>();

	    /**
	     *
	     */
	    static {
	        Properties prop = new Properties();
	        try {
	            prop.load(MessageErrorProperties.class.getResourceAsStream(("/properties/message.properties")));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        Enumeration<String> en  = (Enumeration<String>)prop.propertyNames();
	        while (en.hasMoreElements()) {
	            String key = (String)en.nextElement();
	            data.put(key, prop.getProperty(key));
	        }
	    }

	    /**
	     * getData from file properties
	     * @param key key
	     * @return String
	     */
	    static public String getMessage(String key) {
	        String string = "";
	        if (data.containsKey(key)) {
	            string = data.get(key);
	        }
	        return string;
	    }
}
