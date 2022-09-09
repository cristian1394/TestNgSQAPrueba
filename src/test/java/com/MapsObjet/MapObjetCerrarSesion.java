package com.MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testNG.ClaseBase;


public class MapObjetCerrarSesion extends ClaseBase
{
	//CONSTRUCTOR DE LA CLASE
	public MapObjetCerrarSesion(WebDriver driver) 
	{
		super(driver);
	}
		
		
	//ELEMENTOS PAGINA INICIAL 	
		protected By btnPaul =By.xpath("//header/div[1]/div[2]/ul[1]/li[1]/span[1]/i[1]");
		protected By btnLogout =By.xpath("//a[contains(text(),'Logout')]");
		

}
