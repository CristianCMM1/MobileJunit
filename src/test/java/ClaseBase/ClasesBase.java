package ClaseBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.itextpdf.text.DocumentException;

import utilidadesExcel.GenerarReportePdf;

public class ClasesBase {

	protected static WebDriver driver;
	
    //CONSTRUCTOR DE LA CLASE 
	public ClasesBase(WebDriver driver) {
		super();
	}
	// METODO DE NAVEGADOR
	public static WebDriver chomeDriverConnection() {
		//SETEAR LAS OPCIONES DEL NAVEGADOR
		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		// SETEAR LAS PROPIEDADES DEL EJECUTABLE DE CHROME
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		//DECLARAR EL OBJETO DRIVER TIPO CHROME DRIVER
		driver= new ChromeDriver();
		
		//MAXIMIZAR LA VENTANA DE NAVEGADOR 
		driver.manage().window().maximize();
		return driver;
	}
	//METODO CLICK
	public void click(By locator,File rutaCarpeta, String generarEvidencia)throws Exception{
		try {
			driver.findElement(locator).click();
			tiempoEspera(2000);
			captureScreen(rutaCarpeta, locator, generarEvidencia);
		} catch (Exception e) {
			captureScreenError(rutaCarpeta, locator, generarEvidencia,e.toString());
			throw new InterruptedException();
		}	
	}
	//METODO BORRAR 
	public void borrar(By locator,File rutaCarpeta, String generarEvidencia ) throws IOException, DocumentException {
		driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		//driver.findElement(locator).clear();
		captureScreen(rutaCarpeta, locator, generarEvidencia);
	}
	
	//METODO ENVIAR TEXTO
	public void sendkey(String inputText, By locator,File rutaCarpeta, String generarEvidencia) throws IOException, DocumentException {
		driver.findElement(locator).sendKeys(inputText);
		captureScreen(rutaCarpeta, locator, generarEvidencia);
	}
	//METODO ENTER SUBMIN
	public void submit(By locator,File rutaCarpeta,String generarEvidencia) throws IOException, DocumentException {
		driver.findElement(locator).submit();
		captureScreen(rutaCarpeta, locator, generarEvidencia);
	}
	//METODO TIEMPO DE ESPERA
	public void tiempoEspera(long tiempo)throws InterruptedException{
		Thread.sleep(tiempo);
	}
	//METODO LISTA DE ELEMENTOS
	public List<WebElement> listaElementos(By locator) throws Exception
    {
      
        List<WebElement> elemento=driver.findElements(locator);
        return elemento;
        
    }
	//METODO FECHA HORA
	public static String fechaHora() {
		
		//TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema= LocalDateTime.now();
		
		//DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
		
		//DAR FORMATO A LA FECHA DEL SISTEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;	
}
	//METODO FECHA HORA 2
	public static String fechaHora2() {
		
		//TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema= LocalDateTime.now();
		
		//DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MMdd-dd HH:mm:ss");
		
		//DAR FORMATO A LA FECHA DEL SISTEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;	
}
	//METODO ELIMINAR ARCHIVO
	public void eliminarArchivo(String rutaImagen) {
		
		File fichero = new File(rutaImagen);
		fichero.delete();
	}
	
	// METODO HORA DEL SISTEMA 
	public String HoraSistema() {
		
		//TOMAMOS LA FECHA DEL SISTEMA 
		LocalTime horaSistema = LocalTime.now();
		
		//DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");
		
		//DAR FORMATO A LA FECHA DEL SISTEMA
		String hora = fecha.format(horaSistema);
		return hora;	
	}
	
	// METODO HORA DEL SISTEMA 
		public String fechaSistema() {
			
			//TOMAMOS LA FECHA DEL SISTEMA 
			LocalDateTime fechaSistema = LocalDateTime.now();
			
			//DEFINIR FORMATO FECHA
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			
			//DAR FORMATO A LA FECHA DEL SISTEMA
			String formatfecha = fecha.format(fechaSistema);
			return formatfecha;	
		}
		
		
	public void captureScreen(File rutaCarpeta,By locator,String generarEvidencia) throws IOException, DocumentException {
		
		if (generarEvidencia.equals("Si")) {
			String hora= HoraSistema();
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(rutaCarpeta+"\\"+hora+".png"));
			String rutaImagen = new File(rutaCarpeta+"\\"+hora+".png").toString();
			
			//INSTANCIAMOS LA CLASE GENERAR PDF
			GenerarReportePdf informePdf = new GenerarReportePdf();
			
			//INSERTAR LOCALIZADOR DE IMAGEN EN EL PDF
		    informePdf.crearbody(locator,rutaImagen);

		    //ELIMINAR IMAGEN CREADA
		    eliminarArchivo(rutaImagen);
		}
	
	}
	
	public void captureScreenError(File rutaCarpeta, By locator, String generarEvidencia, String msnError) throws Exception
    {
        if (generarEvidencia.equals("Si"))
        {
            String hora = HoraSistema();
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
            String rutaImagen =new File(rutaCarpeta+"\\"+hora+".png").toString();
            
            //INSTACIAMOS LA CLASE GENERAR PDF
            GenerarReportePdf informePdf = new GenerarReportePdf();
            //SE PROCEDE A INSERTAR LOCALIZADOR HE IMAGEN EN EL PDF
            informePdf.crearbodyError(locator,rutaImagen,msnError);
            //ELIMINAR IMAGEN CREADA
            
            eliminarArchivo(rutaImagen);
    }
  }
	public File crearCarpeta(Properties propiedades, String nomTest) {
		
		//ALMACENAMOS LA FECHA DEL SISTEMA
		String fecha =fechaHora();
		
		//CREAMOS EL NOMBRE DE LA CARPETA
		String nomCarpeta = nomTest+"-"+fecha;
		
		//OBTENEMOS LA RUTA DE ALOJAMMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR
		File directorio = new File ("./output/"+nomCarpeta);
		
				
		//CREAMOS LA CARPETA
		directorio.mkdir();
		return directorio;
		
	}
}