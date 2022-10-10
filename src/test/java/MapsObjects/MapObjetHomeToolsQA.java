package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClaseBase.ClasesBase;

public class MapObjetHomeToolsQA extends ClasesBase {
	
	//CONSTRUCTOR DE LA CLASE
	public MapObjetHomeToolsQA(WebDriver driver) {
		super(driver);
	}
	//ELEMENTOS DE LA CLASE PRINCIPAL
	protected By linkAlertaFrameswindows = By.xpath("(//div[@class='card-up'])[3]");
	protected By linkWidgets = By.xpath("//h5[text()='Widgets']");
}
