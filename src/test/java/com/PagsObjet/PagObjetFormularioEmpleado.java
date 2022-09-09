package com.PagsObjet;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.MapsObjet.MapObjetEmpleado;
import com.MapsObjet.MapObjetFormularioEmpleado;
import com.MapsObjet.MapObjetInicio;

public class PagObjetFormularioEmpleado extends MapObjetFormularioEmpleado
{
	String url;
	
	public void setUrl(String url) {
		this.url = url;
	}

	// CREAR CONSTRUCTOR DE LA CLASE
	public PagObjetFormularioEmpleado(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}

	// METODO INICIAL
	public void urlAcceso()
	{
		driver.get(url);
	}

	// METODO PRIMERA PRUEBA
	public PagObjetFormularioEmpleado Formulario (String nickName,String OtherId,String driverLicense,String licenseExpiry, 
			String ssnNumber,String sinNumber,String Nationality,String maritalStatus,String dateBirth,
			String militaryService,File rutaCarpeta, String generarEvidencia) throws Exception
	{
		try
		{
             tiempoEspera(3);
			
		    sendkey(nickName, txtNickName, rutaCarpeta,generarEvidencia);
			sendkey(OtherId, txtOtherId, rutaCarpeta,generarEvidencia);
			sendkey(driverLicense, txtDriverLicense, rutaCarpeta,generarEvidencia);
			sendkey(licenseExpiry, txtlicenseExpiry, rutaCarpeta,generarEvidencia);
			JavascriptExecutor js=(JavascriptExecutor)driver;
	         js.executeScript("window.scrollBy(0,100)");
			sendkey(ssnNumber, txtSsnNumber, rutaCarpeta,generarEvidencia);
			sendkey(sinNumber, txtSinNumber, rutaCarpeta,generarEvidencia);
			JavascriptExecutor je=(JavascriptExecutor)driver;
	         je.executeScript("window.scrollBy(0,100)");
	         
	         click(txtNationality1, rutaCarpeta, generarEvidencia);
	         tiempoEspera(1);
			sendkey(dateBirth, txtDateBirth, rutaCarpeta,generarEvidencia);
			click(btnGender, rutaCarpeta, generarEvidencia);
			sendkey(militaryService, txtMilitaryService, rutaCarpeta,generarEvidencia);
			click(btnSmoker, rutaCarpeta, generarEvidencia);
			click(btnSave, rutaCarpeta, generarEvidencia);
			tiempoEspera(6);
			
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return this;
	}
}
