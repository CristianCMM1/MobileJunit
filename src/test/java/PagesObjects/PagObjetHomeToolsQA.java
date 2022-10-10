package PagesObjects;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.itextpdf.text.DocumentException;

import MapsObjects.MapObjetHomeToolsQA;
import utilidadesExcel.ReadExcelFiles;

public class PagObjetHomeToolsQA extends MapObjetHomeToolsQA {

	public PagObjetHomeToolsQA(WebDriver driver) {
		super(driver);
	}

	// METODO INICIAL
	public void urlAcceso(ReadExcelFiles leer,Properties propiedades) throws IOException {
		driver.get(leer.getCellValue(propiedades.getProperty("filePathExcel"), "toolsqa", 1, 0));
	}

	// METODO LINK ALERTAS
	public void homeAlertsToolsQA(ReadExcelFiles leer, Properties propiedades, File rutaCarpeta,String generarEvidencia)
			throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    // This  will scroll down the page by  1000 pixel vertical        
	    js.executeScript("window.scrollBy(0,200)");
	    
		click(linkAlertaFrameswindows, rutaCarpeta, generarEvidencia);
		tiempoEspera(2000);	
	}
	// METODO LINK WIDGETS
		public void homeWidgetsToolsQA(ReadExcelFiles leer, Properties propiedades, File rutaCarpeta, String generarEvidencia)
				throws Exception {
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    // This  will scroll down the page by  1000 pixel vertical        
		    js.executeScript("window.scrollBy(0,200)");
			click(linkWidgets, rutaCarpeta,generarEvidencia);
			tiempoEspera(2000);	
		}
	
	
}