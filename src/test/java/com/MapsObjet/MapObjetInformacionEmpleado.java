package com.MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testNG.ClaseBase;


public class MapObjetInformacionEmpleado extends ClaseBase
{
	//CONSTRUCTOR DE LA CLASE
	public MapObjetInformacionEmpleado(WebDriver driver) 
	{
		super(driver);
	}
		
	//ELEMENTOS PAGINA INICIAL 	
	 	
		protected By btnPim =By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]");
		protected By txtEmployeeName =By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]");
		protected By btnSearch =By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[2]/button[2]");
		protected By btnID =By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]/span[1]/i[1]");
		protected By btnEliminar =By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[9]/div[1]/button[1]/i[1]");
		protected By btnEliminar2 =By.xpath("//body/div[@id='app']/div[3]/div[1]/div[1]/div[1]/div[3]/button[2]");
		
}
