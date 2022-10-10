package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClaseBase.ClasesBase;

public class MapObjetWidgwestToolsQA extends ClasesBase {

	public MapObjetWidgwestToolsQA(WebDriver driver) {
		super(driver);
	}

	//ELEMENTOS DE WIDGETS
	protected By linkDatePicker = By.xpath("//span[text()='Date Picker']");
	protected By selectDate = By.id("datePickerMonthYearInput");
	//protected By desplegarMes = By.xpath("//select[@class='react-datepicker__month-select']");
	protected By selectMes = By.xpath("//*[@id='datePickerMonthYear']/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select/option");
	//*[@id="dateAndTimePicker"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/div
	//protected By selectSemana= By.xpath("//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[2]/div");
	protected By selectDia=By.xpath("//*[@id='datePickerMonthYear']/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]");
	protected By dateAndTime = By.id("dateAndTimePickerInput");
	protected By selectMesDateAndTime = By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']");
	protected By diadateAndTime= By.xpath("//div[@class='react-datepicker__day react-datepicker__day--007 react-datepicker__day--weekend']");
	protected By horaDateAndTime= By.xpath("//*[@id=\"dateAndTimePicker\"]/div[2]/div[2]/div/div/div[3]/div[2]/div/ul/li");
}
