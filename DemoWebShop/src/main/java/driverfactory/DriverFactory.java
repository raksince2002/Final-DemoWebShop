package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
	
	private static WebDriver wd;
	
	private DriverFactory() {
	}
	
	public static WebDriver getinstance() {
		if(wd==null) {
			wd=new EdgeDriver();
		}
		return wd;
	}
	
	
}
