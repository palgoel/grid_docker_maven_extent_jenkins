package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configDataProvider {
	
	Properties prop;
	
	public configDataProvider() {
		File src = new File("./Config/config.properties");
		try {
			FileInputStream file = new FileInputStream(src);
			prop = new Properties();
			prop.load(file);
		    } catch (Exception e) {
			System.out.println("Not able to load config file"+e.getMessage());
		}

	}
	public String getBrowser() {
		return prop.getProperty("browser");
	}
	
	public String getEsodUrl() {
		return prop.getProperty("esod_url");
	}
	public String getGoogleUrl() {
		return prop.getProperty("google_url");
	}
	
	

}
