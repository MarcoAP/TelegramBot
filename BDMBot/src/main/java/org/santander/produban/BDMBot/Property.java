package org.santander.produban.BDMBot;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Property {

	InputStream inputStream;

	public String getPropertyValues(String propertyName, String fileName) throws IOException {

		try { 
			Properties prop = new Properties();
			String propFileName = (fileName == null) ? "config.properties" : fileName.concat(".properties");

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("Arquivo de properties '" + propFileName + "' não encontrado!");
			}

			return prop.getProperty(propertyName);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return null;
	}

	// public static void main(String[] args) {
	// Property g = new Property();
	// try {
	// System.out.println(g.getPropertyValues("TOKEN"));
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
}
