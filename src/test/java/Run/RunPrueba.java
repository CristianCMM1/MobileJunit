package Run;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import ClaseBase.ClasesBase;
import PagesObjects.PagObjetAlertsToolsQA;
import PagesObjects.PagObjetHomeToolsQA;
import PagesObjects.PageObjectWindgestToolsQA;
import utilidadesExcel.GenerarReportePdf;
import utilidadesExcel.MyScreenRecorder;
import utilidadesExcel.ReadExcelFiles;
import utilidadesExcel.WriteExcelFiles;

public class RunPrueba {
	private WebDriver driver;
	
	Properties propiedades;
	ReadExcelFiles leer;
	WriteExcelFiles escribir;
	ClasesBase claseBase;
	PagObjetHomeToolsQA homeToolsQA;
	PagObjetAlertsToolsQA alertsToolsQA;
	PageObjectWindgestToolsQA windgesToolsQA;
	GenerarReportePdf generarReportePdf;
	@Before
	public void setUp() throws IOException {
		//INSTANCIAR LA CLASE PROPIEDADES DE JAVA UTIL
		 propiedades = new Properties();
		 
		 //INSTANCIAR LAS PROPIEDADES DEL EXCEL
		 leer = new ReadExcelFiles();
		 escribir = new WriteExcelFiles();
		
		//CREAR VARIABLES TIPO INPUTSTRING
		InputStream entrada = null;
		
		//VALIDAR SI GENERA ERROR AL NO ENCONTRAR EL ARCHIVO
		
		try {
			entrada= new FileInputStream("./Properties/datos.properties");
			propiedades.load(entrada);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		}
			
		
		//ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		driver= ClasesBase.chomeDriverConnection();
		System.out.println("zzzzzz");
		claseBase = new ClasesBase(driver);
		
		//INSTANCIAR CLASE GENERAR REPORTES
		generarReportePdf = new GenerarReportePdf();
		
		//INSTANCIAR LA CLASE HOME TOOLSQA
		homeToolsQA = new PagObjetHomeToolsQA(driver);
		
		//INSTANCIAR LA CLASE ALERTS
		alertsToolsQA = new PagObjetAlertsToolsQA(driver);
		
		//INSTANCIAR LA CLASE WIDGEST
		windgesToolsQA = new PageObjectWindgestToolsQA(driver);
		
		
		
		//GENERAR RUTA PDF
		//generarReportePdf.setRutaImagen(propiedades.getProperty("rutaImagenReporte"));
	}
	
	@Test
	public void testAlertsToolsQA() throws Exception{
		
		String generarEvidencia="Si";
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
										
		//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades, nomTest);
		
		//URL DESDE ARCHIVO EXCEL
		homeToolsQA.urlAcceso(leer,propiedades);
		//INICIA GRABACION DE VIDEO
		//MyScreenRecorder.starRecording(nomTest, rutaCarpeta);
		
		//GENERAR PDF
		generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
		
		//ACCEDER A ALERTAS 
		homeToolsQA.homeAlertsToolsQA(leer, propiedades, rutaCarpeta, nomTest);
		//alertsToolsQA.alertasToolsQA(leer, propiedades, rutaCarpeta);
		
		//CERRAR EL PDF
		generarReportePdf.cerrarPlantilla();
		
		//DETENER LA GRABACION
		//MyScreenRecorder.StopRecording();
		
	}	
	/*
	@Test
	public void testWidgestToolsQA() throws Exception{
		
		
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
										
		//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades, nomTest);
		
		//ACCEDER AL WIDGEST
		homeToolsQA.homeWidgetsToolsQA(leer, propiedades, rutaCarpeta);
		windgesToolsQA.widgestToolsQA(leer, propiedades, rutaCarpeta);

	}	
	
	@Test
	public void testWidgestToolsQAOpt() throws Exception{
		
		
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
										
		//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades, nomTest);
		
		//INICIA GRABACION DE VIDEO
		MyScreenRecorder.starRecording(nomTest, rutaCarpeta);
		
		//GENERAR PDF
		generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
		
		//ACCEDER AL WIDGEST
		homeToolsQA.homeWidgetsToolsQA(leer, propiedades, rutaCarpeta);
		windgesToolsQA.widgestToolsQAOptimizado(leer, propiedades, rutaCarpeta, nomTest);
		
		//CERRAR EL PDF
		generarReportePdf.cerrarPlantilla();
		
		//DETENER LA GRABACION
		MyScreenRecorder.StopRecording();
		
	}	
	*/
	
	@After
	public void cerrar() {
		driver.quit();
	}
}
