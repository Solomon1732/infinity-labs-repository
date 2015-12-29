package com.ilad.propertyfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import com.ilad.browser.BrowserPropertyConstants;

/**
 * A properties file manager. This class is a singleton. The class is capable
 * of use in conditions requiring synchronization
 * @author Shlomi Reuveni
 * @since Dec 28 2015
 */
public class PropertyFile {
	/**
	 * A Properties instance to manage the file
	 */
	private static final Properties properties = new Properties();
	/**
	 * The default file name
	 */
	private static final  String m_fileName = "conf.properties";
	/**
	 * A singleton instance of the class
	 */
	private static PropertyFile instance;
	/**
	 * A synchronization mutex
	 */
	private static final Object mutex = new Object();

	/**
	 * An overwriting of the default class constructor
	 */
	private PropertyFile() { }

	/**
	 * Get an instance of the class
	 * @return a reference for an instance of the class
	 */
	public static PropertyFile getInstance() {
		if(null == instance) {
			synchronized (mutex) {
				if(null == instance) {
					instance = new PropertyFile();
				}
			}
		}
		
		return instance;
	}
	
	/**
	 * Set a property in the file
	 * @param username the name of the property
	 * @param value the value of the property
	 * @param comment a comment for the property. If null in received, than no
	 * comment is written
	 * @return the value previously stored in the property. If there was no
	 * value, null is returned
	 * @throws IOException
	 */
	public String setProperty(BrowserPropertyConstants key, String value, String comment) throws IOException {
		String previousValue = (String) properties.setProperty(key.getPropertyValue(), value);

		try (FileWriter writer = new FileWriter(m_fileName)) {
			properties.store(writer, comment);
		} catch (IOException e) {
			throw e;
		}
		return previousValue;
	}
	
	/**
	 * Get a property from the configuration file
	 * @param key the name of the property which holds the value
	 * @return a string containing the value of the property. The method
	 * returns null if the property is not found
	 * @throws IOException 
	 * @throws FileNotFoundException
	 */
	public String getProperty(BrowserPropertyConstants key) throws IOException, FileNotFoundException {
		String property = null;
		
		if(!(new File("conf.properties")).exists()) {
			throw new FileNotFoundException();
		}

		try (FileReader reader = new FileReader(m_fileName)) {
			properties.load(reader);
			property = properties.getProperty(key.getPropertyValue());
		} catch (IOException e) {
			throw e;
		}

		return property;
	}
}

