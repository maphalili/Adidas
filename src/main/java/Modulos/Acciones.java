package Modulos;

import java.util.List;

import javax.sound.sampled.Line;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Report.ExtentReport;

public class Acciones {

	WebDriver webDriver;

	public Acciones(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public WebDriver BuscarProducto(String producto, ExtentReport reporte) throws InterruptedException {

		WebElement Buscador = webDriver.findElement(By.name("q"));
		Buscador.sendKeys(producto);
		reporte.testPassed("Busqueda del producto", "BusquedaProducto");
		Thread.sleep(2000);
		Buscador.submit();
		return webDriver;
	}

	public void seleccionarProducto(WebDriver webDriver, ExtentReport reporte) throws InterruptedException {

//		WebElement elementos = webDriver.findElement(By
//				.xpath("//*[@id=\"app\"]/div/div[3]/div/div[3]/div/div/div[2]/div[2]/div[2]/div/div/div/div[1]/a/img"));
//		elementos.click();
		reporte.testPassed("Productos", "Productos");
		Thread.sleep(9000);
		List<WebElement> lista = webDriver.findElements(By.className("gl-product-card-container"));
		if (lista.size() > 0) {
			lista.get(0).click();
		}
		System.out.println("Cantidad " + lista.size());

	}

	public void AnadirCarrito(ExtentReport reporte) {
		try {
			Thread.sleep(6000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		reporte.testPassed("Producto seleccionado", "Seleccion");
		
		String msgLabel = "";
//		WebElement Anadir = webDriver.findElement(By.linkText("#arrow-right-long"));
//		Anadir.click();
		List<WebElement> botones = webDriver.findElements(By.tagName("button"));
		if (botones.size() > 0) {
			for (int j = 0; j < botones.size(); j++) {
				msgLabel = botones.get(j).getAttribute("aria-label");
				if (msgLabel != null) {
					if (msgLabel.contains("adir al carrito")) {
						botones.get(j).click();
						j = botones.size();
					}
				}

			}
		}
	}

	public void validarProducto(ExtentReport reporte) throws InterruptedException {
		Thread.sleep(15000);
		boolean bandera = false;
		List<WebElement> listaClas = webDriver.findElements(By.tagName("h5"));
		for (int i = 0; i < listaClas.size(); i++) {
			if(listaClas.get(i).getText()!=null) {
				if (listaClas.get(i).getText().trim().toLowerCase().contains("dido al carrito correctamente")) {
					reporte.testPassed("Prueba Exitosa", "Exitoso");
					System.out.println(listaClas.get(i).getText() + "/n" + "Prueba exitosa");
					bandera = true;
					i=listaClas.size();
					
				}
			}
			
		}
		if (bandera) {
			reporte.testfail("Prueba fallida", "Error");
		}
	}
}
