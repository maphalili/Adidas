package Controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ControllerDrivers {
	
	private String navegador;
	private String rutaDriverNavegador;
	private WebDriver webDriver;
	
	
	public ControllerDrivers(String navegador) {
		if (navegador.contains("google")) {
			this.navegador = "Google";
		} else if (navegador.contains("explorer")) {
			this.navegador = "iexplorer";
		}

		rutaDriverNavegador = pathDriver(this.navegador);
		webDriver = abrirNavegador();
	}
		private String pathDriver(String opc) {
			String ruta = System.getProperty("user.dir") + "\\drivers\\";
			
			switch (opc) {
			case "Google":
				ruta = ruta + "chromedriver.exe";
				break;
			case "iexplorer":
				ruta = ruta + "IEDriverServer.exe";
				break;
			default:
				break;
			}
		 return ruta;
		}
		

		private WebDriver abrirNavegador() {
			WebDriver webDriverNavegador = null;
			if (navegador.equalsIgnoreCase("Google")) {
			System.setProperty("webdriver.chrome.driver", rutaDriverNavegador);
			webDriverNavegador = new ChromeDriver();
			} else if (navegador.equalsIgnoreCase("iexplorer")) {
				System.setProperty("webdriver.ie.driver", rutaDriverNavegador);
				webDriverNavegador = new InternetExplorerDriver();
			}
			return webDriverNavegador;
		}
		
		public String getRutaDriverNavegador() {
			return rutaDriverNavegador;
		}
		public void setRutaDriverNavegador(String rutaDriverNavegador) {
			this.rutaDriverNavegador = rutaDriverNavegador;
		}
		
		public WebDriver getWebDriver() {
			return webDriver;
		}
		public void setWebDriver(WebDriver webDriver) {
			this.webDriver = webDriver;
		}
}