package PagesObjects;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import MapsObjects.MapObjetAlertsToolsQA;
import utilidadesExcel.ReadExcelFiles;

public class PagObjetAlertsToolsQA extends MapObjetAlertsToolsQA {

	

	//CONSTRUCTOR DE LA CLASE
	public PagObjetAlertsToolsQA(WebDriver driver) {
		super(driver);
	}

	//METODO ALERTAS TOOLSQA
	public void alertasToolsQA(ReadExcelFiles leer, Properties propiedades, File rutaCarpeta, String generarEvidencia) throws Exception {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    // This  will scroll down the page by  1000 pixel vertical        
	    js.executeScript("window.scrollBy(0,200)");
		
	    // INGRESAR CLICK EN  ALERTAS
		click(linkAlerts, rutaCarpeta, generarEvidencia);
		tiempoEspera(2000);
		
		//SELECCIONAR ALERTA
		click(btnAlert,rutaCarpeta,generarEvidencia);
		driver.switchTo().alert().accept();
		tiempoEspera(2000);
		
		
		//SELECCIONAR ALERTA CON TIEMPO DE ESPERA
		click(btnTimeAlert, rutaCarpeta,generarEvidencia);
		tiempoEspera(6000);
		driver.switchTo().alert().accept();
		tiempoEspera(2000);
		
		//SELECCIONAR ALERTA CON ACEPTAR O 
		click(btnconfirmButton, rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);
		driver.switchTo().alert().accept();
		tiempoEspera(2000);
		
		//SELECCIONAR ALERTA CON CANCELAR
		click(btnconfirmButton, rutaCarpeta,generarEvidencia);
		tiempoEspera(1000);
		driver.switchTo().alert().dismiss();
	    tiempoEspera(2000);
	    System.out.println(propiedades.getProperty("prueba"));
	    
		//SELECCIONAR ALERTA CON TEXTO
	try {
		click(btnpromtButton, rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);
		driver.switchTo().alert().sendKeys("textoIngresado");
		
		tiempoEspera(2000);
		driver.switchTo().alert().accept();
		tiempoEspera(2000);
	} catch (Exception e) {
		System.out.println(e);
	}
		
	}
}
