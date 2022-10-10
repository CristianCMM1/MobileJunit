package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ClaseBase.ClasesBase;

public class MapObjetAlertsToolsQA extends ClasesBase{

	
	//CONSTRUCTOR DE LA CLASE
	public MapObjetAlertsToolsQA(WebDriver driver) {
		super(driver);
	}
	

	//ELEMENTOS PARA REGISTRARSE
	protected By linkAlerts = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]/span");
	protected By btnAlert = By.id("alertButton");
	protected By btnTimeAlert= By.id("timerAlertButton");
	protected By btnconfirmButton= By.id("confirmButton");
	protected By btnpromtButton= By.id("promtButton");
	
}