package com.MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testNG.ClaseBase;


public class MapObjetInicio extends ClaseBase
{
	//CONSTRUCTOR DE LA CLASE
	public MapObjetInicio(WebDriver driver) 
	{
		super(driver);
	}
		
		
	//ELEMENTOS PAGINA INICIAL 	
		protected By txtUsername =By.xpath("//*[@name='username']");
		protected By txtPassword =By.xpath("//*[@name='password']");
		protected By btnLogin =By.xpath("//*[@type='submit']");
		protected By btnEmployee =By.xpath("//a[contains(text(),'Add Employee')]");

}
