package Controller;

import org.openqa.selenium.WebDriver;

public class Lanzador {

	public WebDriver Lanzar (String Url) {
		WebDriver webDriver = null;
		
		ControllerDrivers controllerDrivers = new ControllerDrivers ("google");
		webDriver = controllerDrivers.getWebDriver();
		webDriver.get(Url);
		return webDriver;
	}
	
}
