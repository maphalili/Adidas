package Main;

import org.openqa.selenium.WebDriver;

import Controller.Lanzador;
import Modulos.Acciones;
import Report.ExtentReport;

public class main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Lanzador lanzador = new Lanzador();
		ExtentReport reporte = new ExtentReport("Adidas");
		reporte.createtest("Abriendo pagina");
		WebDriver webDriver = lanzador.Lanzar("https://www.adidas.co/");
		Thread.sleep(2000);
		Acciones acciones = new Acciones(webDriver);
		reporte.createtest("Busqueda del producto");
		WebDriver objeWeb = acciones.BuscarProducto("tarro", reporte);
		reporte.createtest("Seleccionar producto");
		acciones.seleccionarProducto(objeWeb, reporte);
		reporte.createtest("Adicion al carrito");
		acciones.AnadirCarrito(reporte);
		reporte.createtest("Validacion del producto");
		acciones.validarProducto(reporte);
		reporte.createReporter();
		webDriver.close();
	}

}
