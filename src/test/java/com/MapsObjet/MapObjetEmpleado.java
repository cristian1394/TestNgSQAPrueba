package com.MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testNG.ClaseBase;


public class MapObjetEmpleado extends ClaseBase
{
	//CONSTRUCTOR DE LA CLASE
	public MapObjetEmpleado(WebDriver driver) 
	{
		super(driver);
	}
		
	//ELEMENTOS PAGINA INICIAL 	
	 	
		protected By txtfirstName =By.xpath("//*[@name='firstName']");
		protected By txtMiddleName =By.xpath("//*[@name='middleName']");
		protected By txtlastName =By.xpath("//*[@name='lastName']");
		protected By txtId =By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/input[1]");
		protected By btnSave =By.xpath("//*[@type='submit']");
		

}
