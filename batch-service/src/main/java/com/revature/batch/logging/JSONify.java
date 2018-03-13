package com.revature.batch.logging;


/**
 * 
 * @author Allan Poindexter / Batch 1712_dec11th_Java_Steve
 * 		   Charlie Harris / Batch 1712_dec11th_Java_Steve
 * 
 * Class creates simple methods to create key/value pairs for returning log output as JSON.
 *
 */
public class JSONify {
	/**
	 * @author Charlie Harris / Batch 1712_dec11th_Java_Steve
	 * Surrounds [str] in quotes, e.g. hello --> "hello"
	 * @param str
	 * @return str in quotations
	 */
	public String quotify(String str) {
		return "\"" + str + "\"";
	}

	/**
	 * @author Allan Poindexter / Batch 1712_dec11th_Java_Steve
	 * Creates an Event Key in json.
	 * @param type - start, end, etc.
	 * @param name - name of the event: controller, servce, etc.
	 * @return an event:type JSON string
	 */
	public String addEvent(String type, String name) {
		return "\"" + type + "Event" + "\":\"" + name + "\"";
	}
	
	/**
	 * @author Allan Poindexter / Batch 1712_dec11th_Java_Steve
	 * Adds quotation marks to a JSON key
	 * @param key
	 * @return key in quotations
	 */
	public String addKey(String key) {
		return "\"" + key + "\":";
	}
	
	/**
	 * @author Allan Poindexter / Batch 1712_dec11th_Java_Steve
	 * Adds quotation marks to a JSON value, and a comma
	 * @param value
	 * @return value in quotations
	 */
	public String addValue(String value) {
		return "\"" + value + "\",";
	}
	
	/**
	 * @author Allan Poindexter / Batch 1712_dec11th_Java_Steve
	 * Calls quotify to add quotations to a value. This indicate the end of a JSON string.
	 * @param value
	 * @return value in quotations
	 */
	public String addEndValue(String value) {
		return quotify(value);
	}
}
