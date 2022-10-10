package PagesObjects;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MapsObjects.MapObjetWidgwestToolsQA;
import utilidadesExcel.ReadExcelFiles;

public class PageObjectWindgestToolsQA extends MapObjetWidgwestToolsQA {

	public PageObjectWindgestToolsQA(WebDriver driver) {
		super(driver);
	}

	public void widgestToolsQA(ReadExcelFiles leer, Properties propiedades, File rutaCarpeta,String generarEvidencia) throws Exception {

		// SELECCIONAR DATE PICKER
		tiempoEspera(2000);
		click(linkDatePicker, rutaCarpeta,generarEvidencia);
		tiempoEspera(1000);
		
		// SELECCIONAR SELECT DATE
		click(selectDate, rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);

		// CREACION DE LA LISTA MES
		//click(desplegarMes, rutaCarpeta);
		tiempoEspera(2000);
		List<WebElement> mes = listaElementos(selectMes);

		// INGRESAR MES
		mes.get(7).click();
		tiempoEspera(2000);
		
		
		//click(desplegarMes, rutaCarpeta);
		//tiempoEspera(2000);
		/*
		// CREACION DE LA LISTA DIA
		List<WebElement> semana = listaElementos(selectSemana);

		 //INGRESAR SEMANA
		semana.get(2);
		tiempoEspera(2000);

		// CREACION DE LA LISTA DIA
		List<WebElement> dia = listaElementos(selectDia);
        */
		
		// INGRESAR DIA
		click(selectDia,rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);
		
		//INGRESAR DATE AND TIME 
		click(dateAndTime,rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);
		
		//SELECCIONAR MES ANTERIOR
		click(selectMesDateAndTime,rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);
		
		//SELECCIONAR DIA
		click(diadateAndTime,rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);
		
		//SELECCIONAR LA HORA
		//click(horaDateAndTime,rutaCarpeta);
		tiempoEspera(2000);
		List<WebElement> hora = listaElementos(horaDateAndTime);

		// INGRESAR MES
		hora.get(60).click();
		tiempoEspera(2000);
		captureScreen(rutaCarpeta, dateAndTime, null);
	}
	public void widgestToolsQAOptimizado(ReadExcelFiles leer, Properties propiedades, File rutaCarpeta,String generarEvidencia) throws Exception {
		// SELECCIONAR DATE PICKER
		tiempoEspera(2000);
		click(linkDatePicker, rutaCarpeta,generarEvidencia);
		tiempoEspera(1000);
		
		// SELECCIONAR SELECT DATE
		borrar(selectDate, rutaCarpeta,generarEvidencia);
//click(selectDate, rutaCarpeta);
		tiempoEspera(2000);
		
		
		// LLAMADA AL METODO FECHA SISTEMA
		String fecha2 = fechaSistema();
		String[] fechaVector = fecha2.split("-");
		
		int dia = Integer.parseInt(fechaVector[0]);
		int mes = Integer.parseInt(fechaVector[1]); 
		int year = Integer.parseInt(fechaVector[2]); 
		
		dia= dia-1;
		mes= mes-1;
		year= year-1;
		
		fecha2 = mes+"/"+dia+"/"+year;
		
		//INGRESAR LA FECHA A AGREGAR
		borrar(selectDate, rutaCarpeta,generarEvidencia);
		sendkey(fecha2,selectDate, rutaCarpeta,generarEvidencia);
		
		
		//INGRESAR DATE AND TIME 
		//click(dateAndTime,rutaCarpeta);
		
		//LIMPIAR CAJA DE TEXTO
		tiempoEspera(2000);
		borrar(dateAndTime,rutaCarpeta,generarEvidencia);
		
		//DISMINUIR UN MES Y TRAE EL MES EN LETRAS
		Month mes1= LocalDate.now().minusMonths(1).getMonth();
		fecha2 = mes1+"/"+dia+"/"+year;
		
		//INGRESAR LA FECHA
		sendkey(fecha2,dateAndTime, rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);
		
		//INGRESAR LA HORA

		List<WebElement> hora = listaElementos(horaDateAndTime);
		// INGRESAR MES
		hora.get(39).click();
		tiempoEspera(2000);
		captureScreen(rutaCarpeta, dateAndTime, fecha2);		
	}
}
